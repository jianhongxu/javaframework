package com.xjh.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:38
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName))
        System.out.println("init Car 之前  MyBeanPostProcessor    "+beanName);
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName))
        System.out.println("init Car 之后  postProcessAfterInitialization  "+beanName);
        return bean;
    }

}
