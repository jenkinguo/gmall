package com.guo.gmalluser.service.impl;

import com.guo.gmalluser.mapper.UserMapper;
import com.guo.gmalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-13 17:21
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



}
