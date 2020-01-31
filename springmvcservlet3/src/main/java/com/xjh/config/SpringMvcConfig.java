package com.xjh.config;

import com.xjh.interceptors.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @autor xujianhong
 * @date 2020/1/31 23:46
 * 相当于spring mvc容器 只扫码controller
 */

/**
 * spring mvc 只扫描 Controller
 *
 * useDefaultFilters= false 不用默认的扫描规则
 */
@ComponentScan(basePackages = "com.xjh", includeFilters =
        {@ComponentScan.Filter(type=FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters= false)

// 相当于 xml中的<mvc:annotation-driven>  可以实现WebMvcConfigurer接口 也可以 集成 WebMvcConfigurerAdapter抽象类
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 定制解析jsp页面
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认的jsp解析器
        registry.jsp();
    }


    /**
     * 可以访问静态资源   相当于把spring mvc处理不了的请求交给tomcat处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
