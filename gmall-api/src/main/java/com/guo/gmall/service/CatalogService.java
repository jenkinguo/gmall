package com.guo.gmall.service;

import com.guo.gmall.bean.PmsBaseCatalog1;
import com.guo.gmall.bean.PmsBaseCatalog2;
import com.guo.gmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 21:54
 **/
public interface CatalogService {

    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);

}
