package com.tcl.consumer;

import com.tcl.common.model.User;
import com.tcl.common.service.UserService;
import com.tcl.tclrpc.bootstrap.ConsumerBootstrap;
import com.tcl.tclrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 *
 */
public class ConsumerExample {

    public static void main(String[] args) {
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
//        System.out.println(rpc);

        // 服务提供者初始化
        ConsumerBootstrap.init();

        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("tcl");

        for (int i = 0; i < 1; i++) {
            User newUser = userService.getUser(user);
            if(newUser != null) {
                System.out.println("--------------------"+newUser.getName());
            }else{
                System.out.println("null==user");
            }

            long number = userService.getNumber();
            System.out.println(number);
        }


    }
}
