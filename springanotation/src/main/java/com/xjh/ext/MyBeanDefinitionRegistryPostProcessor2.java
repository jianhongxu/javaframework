package com.xjh.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/29 16:06
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor2 implements BeanDefinitionRegistryPostProcessor {


    /**
     *  是在bean的定义信息还未保存 bean的实例未创建的时候。 在postProcessBeanFactory()方法执行前执行
     * @param registry
     * @throws BeansException
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("22222222MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry : "+ registry.getBeanDefinitionCount()+"个 bean");

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("22222222MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory : "+ beanFactory.getBeanDefinitionCount()+"个 bean");
    }
}
