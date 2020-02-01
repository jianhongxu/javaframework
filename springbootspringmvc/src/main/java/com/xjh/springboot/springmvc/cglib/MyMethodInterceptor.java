package com.xjh.springboot.springmvc.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:27
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o    cglib生成的代理对象
     * @param method   被代理对象方法
     * @param args  方法参数
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println(method.getName()+"方法执行前： "+ Arrays.toString(args));
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println(method.getName()+"方法执行后： "+ result);
        return result;
    }
}
