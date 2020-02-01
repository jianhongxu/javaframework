package com.xjh.springboot.springmvc.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:31
 */
public class Test {

    public static void main(String[] args) {

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        HelloService proxy= (HelloService)enhancer.create();

        // 通过代理对象调用目标方法
        System.out.println(proxy.sayHello());
        System.out.println("=======final修饰的方法没有被动态代理成功=========");

        System.out.println(proxy.sayHelloOthers("myhello"));
    }
}
