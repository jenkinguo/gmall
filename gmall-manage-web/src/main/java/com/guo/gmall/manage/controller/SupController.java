package com.guo.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guo.gmall.bean.PmsProductInfo;
import com.guo.gmall.manage.utils.PmsUploadUtil;
import com.guo.gmall.service.SupService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-27 22:56
 **/
@RestController
@CrossOrigin
public class SupController {

    @Reference
    SupService supService;

    @RequestMapping("/spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = supService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("/saveSpuInfo")
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        String s = supService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        String path = PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(path);
        return path;
    }


}
