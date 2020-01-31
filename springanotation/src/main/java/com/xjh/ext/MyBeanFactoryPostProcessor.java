package com.xjh.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/1/29 15:45
 */


@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 在beanFactory标准此时化后调用，所有的bean定义已经保存在beanFactory，但是bean的实例未创建。
     * @param beanFactory
     * @throws BeansException
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor...............");
        //容器中现在所有定义的bean的name
       String[] beanNames =  beanFactory.getBeanDefinitionNames();
       //容器中一共定义有多少个bean
       int count = beanFactory.getBeanDefinitionCount();

        System.out.println("容器中一共定义有多少个bean:"+count);
        System.out.println("所有的bean的名字是:  "+Arrays.toString(beanNames));



    }
}
