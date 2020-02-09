package com.xjh.mybatisspring;

import com.xjh.service.UserService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Proxy;

/**
 * @autor xujianhong
 * @date 2020/2/9 21:50
 *
 * 可以手动注册bean
 */
public class MybatisBeanFactory implements FactoryBean {

    private Class mapperClass;


    //这里可以注入sqlsession等对象
    @Autowired
    private UserService userService;


    /**
     * 构造函数传入
     * @param mapperClass
     */
    public MybatisBeanFactory(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Override
    public Object getObject() throws Exception {

        Object result = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{mapperClass}, new MyInvocationHandler());
        return result;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
