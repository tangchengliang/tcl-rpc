package com.tcl.provider;

import com.tcl.common.service.UserService;
import com.tcl.tclrpc.RpcApplication;
import com.tcl.tclrpc.config.RegistryConfig;
import com.tcl.tclrpc.config.RpcConfig;
import com.tcl.tclrpc.model.ServiceMetaInfo;
import com.tcl.tclrpc.registry.EtcdRegistry;
import com.tcl.tclrpc.registry.LocalRegistry;
import com.tcl.tclrpc.registry.Registry;
import com.tcl.tclrpc.registry.RegistryFactory;
import com.tcl.tclrpc.server.HttpServer;
import com.tcl.tclrpc.server.VertxHttpServer;
import com.tcl.tclrpc.server.tcp.VertxTcpServer;

/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
//        HttpServer httpServer = new VertxHttpServer();
//        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
