package com.xjh.aop;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @autor xujianhong
 * @date 2020/2/9 0:48
 */
public class Test {

    /**
     * spring的动态代理  默认是看代理的对象是否实现了接口 如果实现接口 那使用jdk动态代理 如果没有实现接口则使用cglib的方式创建。
     * 动态代理指的时运行的时候，根据被代理对象的类的信息，生代理对象的字节码 然后获取代理对象的实例。
     *
     *
     * spring循环依赖有三种情况
     * 1 构造方法注入(会报错)
     * 2 单例setter或者字段注入 (不会报错)singletonFactories ： 单例对象工厂的cache
     *                          earlySingletonObjects ：提前暴光的单例对象的Cache
     *                        singletonObjects：单例对象的cache 三级缓存
     * 3 prototype 原型的方式： 会报错  因为原型的实例不会放入spring缓存
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "$Proxy", new Class[]{com.xjh.aop.DogServiceImpl.class});
        FileOutputStream fo =
                new FileOutputStream("D:\\code2019\\javaframework\\springanotation\\target\\ProxyTEST.class");
        fo.write(proxyClassFile);
        fo.flush();
        fo.close();
    }
}
