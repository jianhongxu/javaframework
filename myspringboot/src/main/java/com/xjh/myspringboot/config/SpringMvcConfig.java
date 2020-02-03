package com.xjh.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class SpringMvcConfig implements WebMvcConfigurer  {

    /**
     * 注册自己的国际化处理获取的区域信息
     * @return
     */
   @Bean
    public MyLocalesolver myLocalesolver() {
        return  new MyLocalesolver();
    }

}
