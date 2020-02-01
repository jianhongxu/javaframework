package com.xjh.springboot.springmvc.cglib;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:22
 * cglib的方式 实动态代理
 */
public class HelloService {

    public HelloService() {
        System.out.println("helloserver 我是构造方法");
    }

    /**
     * final修饰的方法 不能被代理
     * @param name
     */
    final public String sayHelloOthers(String name){
        System.out.println("HelloService say hello to:"+name);
        return "sayHelloOthers";
    }



    public String sayHello(){
        System.out.println("HelloService sayHello");
        return "sayHello";
    }
}
