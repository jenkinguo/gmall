package com.guo.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guo.gmall.bean.PmsBaseAttrInfo;
import com.guo.gmall.bean.PmsBaseAttrValue;
import com.guo.gmall.bean.PmsBaseSaleAttr;
import com.guo.gmall.manage.mapper.PmsBaseAttrInfoMapper;
import com.guo.gmall.manage.mapper.PmsBaseAttrValueMapper;
import com.guo.gmall.manage.mapper.PmsBaseSaleAttrMapper;
import com.guo.gmall.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 22:31
 **/
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;
    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        List<PmsBaseAttrValue> baseAttrValueList = null;
        for (PmsBaseAttrInfo baseAttrInfo : attrInfoList) {
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueList = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            baseAttrInfo.setAttrValueList(baseAttrValueList);
        }

        return attrInfoList;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //保持属性
        pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

        //保存属性值
        List<PmsBaseAttrValue> attrValues = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue attrValue : attrValues) {
            attrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.insertSelective(attrValue);
        }

        return "success";
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }
}
