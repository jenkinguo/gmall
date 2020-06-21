package com.guo.gmall.service;

import com.guo.gmall.bean.PmsProductInfo;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-27 22:58
 **/
public interface SupService {

    List<PmsProductInfo> spuList(String catalog3Id);

    String saveSpuInfo(PmsProductInfo pmsProductInfo);
}
