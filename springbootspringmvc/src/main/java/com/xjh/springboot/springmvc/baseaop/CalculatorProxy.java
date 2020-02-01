package com.xjh.springboot.springmvc.baseaop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/1/27 17:51
 */
public class CalculatorProxy {

    //被代理的对象
    private CalculatorInterface target;

    //构造方法
    public CalculatorProxy(CalculatorInterface target) {
        this.target = target;
    }

    public CalculatorInterface getProxyIntance(){
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{CalculatorInterface.class};

        InvocationHandler invocation = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(method.getName()+":方法调用前"+ Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println(method.getName()+":方法调用后  结果"+ result);
                return result;
            }
        };
        //使用jdk自带的动态代理功能生成代理对象
        CalculatorInterface targetProxy = (CalculatorInterface)Proxy.newProxyInstance(loader, interfaces, invocation);

        return targetProxy;
    }

}
