package com.xjh.myspringboot.config;

import com.xjh.myspringboot.servlet.MyFilter;
import com.xjh.myspringboot.servlet.MyListener;
import com.xjh.myspringboot.servlet.Myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @autor xujianhong
 * @date 2020/2/3 20:19
 *
 * 三大组件的组测.....
 */

@Configuration
public class ThreeServletConfig {


    /**
     * 注册servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean  servletRegistrationBean(){
        return  new ServletRegistrationBean(new Myservlet(),"/myservlet");
    }


    /**
     * 向容器中注册filter
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myservlet"));
        return filterRegistrationBean;
    }


    /**
     * 向容器中注册listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }
}
