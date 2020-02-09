package com.xjh.mybatisspring;

import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @autor xujianhong
 * @date 2020/2/9 22:04
 */
public class MyInvocationHandler implements InvocationHandler {

    //动态代理回调方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String[] values =  method.getAnnotation(Select.class).value();


        System.out.println(values[0]);
        return null;
    }
}
