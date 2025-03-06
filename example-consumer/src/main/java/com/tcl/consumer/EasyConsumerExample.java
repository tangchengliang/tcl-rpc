package com.tcl.consumer;

import com.tcl.common.model.User;
import com.tcl.common.service.UserService;
import com.tcl.tclrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // todo 需要获取 UserService 的实现类对象
//        UserService userService = null;
        User user = new User();
        user.setName("tcl");
//        // 调用
//        User newUser = userService.getUser(user);
//        if (newUser != null) {
//            System.out.println(newUser.getName());
//        } else {
//            System.out.println("user == null");
//        }

//        // 静态代理
//        UserService userService = new UserServiceProxy();
//        User user1 = userService.getUser(user);
//        System.out.println(user1.getName());

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user1 = userService.getUser(user);
        System.out.println(user1.getName());

    }
}