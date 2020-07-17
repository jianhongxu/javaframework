package com.example.springbootcode.config;

import com.example.springbootcode.interceptors.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Tile: spring mvc的配置
 * @Autor: xujianhong
 * @Date: 2020/7/14 11:11
 * @Description:  实现 WebMvcConfigurer 接口 或者继承 WebMvcConfigurerAdapter
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
    }


    /**
     * 设置全局跨域策略
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
        .allowedOrigins("https://domain2.com")
        .allowedMethods("PUT", "DELETE")
        .allowedHeaders("header1", "header2", "header3")
        .exposedHeaders("header1", "header2")
        .allowCredentials(true).maxAge(3600);
    }
}
