package com.guo.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guo.gmall.bean.PmsProductImage;
import com.guo.gmall.bean.PmsProductInfo;
import com.guo.gmall.bean.PmsProductSaleAttr;
import com.guo.gmall.bean.PmsProductSaleAttrValue;
import com.guo.gmall.manage.mapper.PmsProductImageMapper;
import com.guo.gmall.manage.mapper.PmsProductInfoMapper;
import com.guo.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.guo.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.guo.gmall.service.SupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-27 22:59
 **/
@Service
public class SupServiceImpl implements SupService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        List<PmsProductInfo> result = pmsProductInfoMapper.select(pmsProductInfo);
        return result;
    }

    @Override
    public String saveSpuInfo(PmsProductInfo pmsProductInfo) {
        pmsProductInfoMapper.insertSelective(pmsProductInfo);

        String pid = pmsProductInfo.getId();
        //保存图片
        List<PmsProductImage> images = pmsProductInfo.getSpuImageList();
        for (PmsProductImage image : images) {
            image.setProductId(pid);
            pmsProductImageMapper.insertSelective(image);
        }

        //保存属性
        List<PmsProductSaleAttr> saleAttrs = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr saleAttr : saleAttrs) {
            saleAttr.setProductId(pid);
            pmsProductSaleAttrMapper.insert(saleAttr);

            //保存具体属性
            String saleAttrId = saleAttr.getId();
            List<PmsProductSaleAttrValue> values = saleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue value : values) {
                value.setSaleAttrId(saleAttrId);
                pmsProductSaleAttrValueMapper.insertSelective(value);
            }

        }
        return "success";
    }
}
