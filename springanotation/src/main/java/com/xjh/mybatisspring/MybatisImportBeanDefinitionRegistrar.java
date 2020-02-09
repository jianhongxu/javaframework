package com.xjh.mybatisspring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * @autor xujianhong
 * @date 2020/2/9 21:52
 *
 * 这种方式和业务代码几乎没有任何耦合
 */
public class MybatisImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //下面三句代码 可以for循环  (通过mapperScan找到所有dao的类名........)
        //
        List list = Arrays.asList("com.xjh.mybatisspring.UserTestDao","com.xjh.mybatisspring.DogDao");
        for(Object s : list){
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MybatisBeanFactory.class);
            BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            //传入全类名
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(s.toString());

            registry.registerBeanDefinition(s.toString().substring(s.toString().lastIndexOf(".")+1),beanDefinition);
        }


    }
}
