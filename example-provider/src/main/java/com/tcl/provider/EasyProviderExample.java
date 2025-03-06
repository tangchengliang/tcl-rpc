package com.tcl.provider;


import com.tcl.common.service.UserService;
import com.tcl.tclrpc.registry.LocalRegistry;
import com.tcl.tclrpc.server.HttpServer;
import com.tcl.tclrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
//        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
//
//        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}