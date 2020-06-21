package com.guo.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guo.gmall.bean.PmsBaseAttrInfo;
import com.guo.gmall.bean.PmsBaseSaleAttr;
import com.guo.gmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-25 22:29
 **/
@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    @RequestMapping("/attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> result = attrService.attrInfoList(catalog3Id);
        return result;
    }

    @RequestMapping("/saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        String result = attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "success";
    }

    @RequestMapping("/baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return  attrService.baseSaleAttrList();
    }

    /*@RequestMapping(value = "/message/send", method = RequestMethod.POST)
    @ResponseBody
    public String testParams(@RequestParam("gzj_content") String content) {
        System.out.println(content);
        return "success";
    }

    @RequestMapping(value = "/message/send2", method = RequestMethod.POST)
    @ResponseBody
    public String testParams2(@RequestBody Map entity) {
        System.out.println(entity);
        return "success";
    }*/

}
