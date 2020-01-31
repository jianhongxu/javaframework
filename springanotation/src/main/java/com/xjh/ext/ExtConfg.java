package com.xjh.ext;

import com.xjh.dto.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @autor xujianhong
 * @date 2020/1/29 15:38
 *
 * Spring扩展类的原理讲解
 *
 * BeanPostProcessor： bean的后置处理器： 是在bean创建对象init方法前后进行拦截工作的。
 *1、  BeanFactoryPostProcessor ：是beanFactory的后置处理器
 *                  在beanFactory标准此时化后调用，所有的bean定义已经保存在beanFactory，但是bean的实例未创建。
 *
 *      ->    BeanDefinitionRegistryPostProcessor: 是在bean的定义信息还未保存 bean的实例未创建的时候。
 *            可以利用BeanDefinitionRegistryPostProcessor往容器中添加组件  BeanDefinitionRegistryPostProcessor优先与BeanFactoryPostProcessor执行。
 *
 *
 *2、ApplicationListener : 监听容器中发布的事件， 事件驱动模型开发
 *   1) 自定以类实现ApplicationListener接口  监听事件
 *   2） 在spring容器中任何一个bean的任何一个方法加上主键@EventListener({ApplicationEvent.class}) 就可以监听事件
 *
 * 3、spring容器的创建的流程
 *    refresh();
 *     刷新前预处理 prepareRefresh();
 *
 */

@Configuration
@ComponentScan(basePackages = "com.xjh.ext")
public class ExtConfg {


    @Bean
    public Car car(){
        return new Car();
    }

}
