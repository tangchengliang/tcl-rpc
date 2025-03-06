package com.tcl.tclrpc.proxy;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        /**
         * 这是Java标准库中 java.lang.reflect.Proxy 类的一个静态方法，用于创建动态代理对象。
         *
         *  它需要三个参数：
         *
         * 类加载器 (ClassLoader): 用于加载代理类。这里使用 serviceClass.getClassLoader() 获取传入接口的类加载器。
         *
         * 接口数组 (Class<?>[]): 代理类要实现的接口。这里传入 new Class[]{serviceClass}，表示代理类只实现 serviceClass 这个接口。
         *
         * InvocationHandler: 这是一个接口，定义了代理对象的方法调用逻辑。这里传入 new ServiceProxy()，表示使用 ServiceProxy 类的实例来处理方法调用。
         */

        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
