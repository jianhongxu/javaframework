package com.xjh.ext;

import com.xjh.dto.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/29 16:06
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    /**
     *  是在bean的定义信息还未保存 bean的实例未创建的时候。 在postProcessBeanFactory()方法执行前执行
     * @param registry
     * @throws BeansException
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry : "+ registry.getBeanDefinitionCount()+"个 bean");

        BeanDefinition beanDefinition = new RootBeanDefinition(Dog.class);
        registry.registerBeanDefinition("test", beanDefinition);

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory : "+ beanFactory.getBeanDefinitionCount()+"个 bean");
    }
}
