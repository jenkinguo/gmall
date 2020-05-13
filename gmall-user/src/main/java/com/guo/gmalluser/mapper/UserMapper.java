package com.guo.gmalluser.mapper;

import com.guo.gmalluser.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author : JenkinGuo
 * @program: gmall
 * @description
 * @date : 2020-05-13 17:18
 **/
public interface UserMapper extends Mapper<UmsMember> {

    //@Select("select * from ums_member")
    //List<UmsMember> selectAllUser();
}
