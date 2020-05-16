package com.guo.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guo.gmall.bean.UmsMember;
import com.guo.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-13 17:23
 **/
@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public List<UmsMember> getAllUsers() {
        List<UmsMember> users = userService.getAllUser();
        return users;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return " hello user";
    }

}
