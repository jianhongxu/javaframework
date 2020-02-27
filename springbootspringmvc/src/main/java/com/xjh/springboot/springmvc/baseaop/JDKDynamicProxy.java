package com.xjh.springboot.springmvc.baseaop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/1/27 17:51
 *
 * JDK默认的动态代理， 可以代理实现接口的任何类
 */
public class JDKDynamicProxy {

    //被代理的对象
    private Object target;


    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * 获取被代理接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        InvocationHandler invocation = new InvocationHandler() {

            /**
             *
             * @param proxy  代理对象实例 实际调用的时候不能使用它  使用后会形成死循环
             * @param method 调用的的方法
             * @param args   调用方法的参数列表
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(method.getName()+":方法调用前"+ Arrays.toString(args));
                //真实的调用方法
                Object result = method.invoke(target, args);
                System.out.println(method.getName()+":方法调用后  结果"+ result);
                return result;
            }
        };
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocation);
    }
}
