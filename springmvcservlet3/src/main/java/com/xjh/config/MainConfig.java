package com.xjh.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @autor xujianhong
 * @date 2020/1/31 23:40
 */

//在web容器启动的时候会初始化
public class MainConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 获取根容器的配置文件  spring的配置文件  父容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    /**
     * 获取web容器（spring mvc的配置文件）
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 获取dispatcherservlet的映射信息
     * / :表示拦截所有请求 包括静态资源 但是不包括 jsp文件
     * /*: 表示拦截所有请求 包括jsp页面
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
