package com.guo.gmalluser.controller;

import com.guo.gmalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-13 17:23
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public String hellouser() {
        return " hello user";
    }

}
