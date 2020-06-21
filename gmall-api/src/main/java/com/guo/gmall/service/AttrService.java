package com.guo.gmall.service;

import com.guo.gmall.bean.PmsBaseAttrInfo;
import com.guo.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 22:30
 **/
public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
