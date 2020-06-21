package com.guo.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guo.gmall.bean.PmsBaseCatalog1;
import com.guo.gmall.bean.PmsBaseCatalog2;
import com.guo.gmall.bean.PmsBaseCatalog3;
import com.guo.gmall.manage.mapper.Catalog1Mapper;
import com.guo.gmall.manage.mapper.Catalog2Mapper;
import com.guo.gmall.manage.mapper.Catalog3Mapper;
import com.guo.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 21:55
 **/
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    Catalog1Mapper catalog1Mapper;

    @Autowired
    Catalog2Mapper catalog2Mapper;

    @Autowired
    Catalog3Mapper catalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 catalog2 = new PmsBaseCatalog2();
        catalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> catalog2s = catalog2Mapper.select(catalog2);
        return catalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 catalog3 = new PmsBaseCatalog3();
        catalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> catalog3s = catalog3Mapper.select(catalog3);
        return catalog3s;
    }
}
