package com.xjh.config;

import com.xjh.dto.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:01
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata  当前类的所有注解信息
     * @param registry  可以手工注册bean
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Yellow.class);
        //可以根据条件注册bean的名字  和 bean的实例
        registry.registerBeanDefinition("Yellow",rootBeanDefinition);

    }
}
