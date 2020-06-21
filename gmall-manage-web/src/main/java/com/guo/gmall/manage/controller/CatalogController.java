package com.guo.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guo.gmall.bean.PmsBaseCatalog1;
import com.guo.gmall.bean.PmsBaseCatalog2;
import com.guo.gmall.bean.PmsBaseCatalog3;
import com.guo.gmall.service.CatalogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 22:01
 **/
@RestController
@CrossOrigin
public class CatalogController {

    @Reference
    CatalogService catalogService;

    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        return catalogService.getCatalog2(catalog1Id);
    }

    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        return catalogService.getCatalog3(catalog2Id);
    }

}
