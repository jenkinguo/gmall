package com.guo.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guo.gmall.bean.UmsMember;
import com.guo.gmall.service.UserService;
import com.guo.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public List<UmsMember> getAllUser() {

        //List<UmsMember> umsMembers = userMapper.selectAllUser();
        List<UmsMember> umsMembers = userMapper.selectAll();
        return umsMembers;
    }

}
