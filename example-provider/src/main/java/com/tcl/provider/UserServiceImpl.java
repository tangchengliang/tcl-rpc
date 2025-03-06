package com.tcl.provider;

import com.tcl.common.model.User;
import com.tcl.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        user.setName("sb");
        return user;
    }
}