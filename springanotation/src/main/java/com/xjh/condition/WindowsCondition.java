package com.xjh.condition;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @autor xujianhong
 * @date 2020/1/27 19:26
 * 注解的条件
 */
public class WindowsCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1、context中可以获取
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、可以获取ClassLoader
        ClassLoader classLoader = context.getClassLoader();
        //3、可以获取bean定义的信息
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();

        //4、可以获取spring的执行环境信息
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");

        return osName.contains("Windows");
    }
}
