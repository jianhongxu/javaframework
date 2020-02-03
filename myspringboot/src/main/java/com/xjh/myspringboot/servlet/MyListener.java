package com.xjh.myspringboot.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @autor xujianhong
 * @date 2020/2/3 20:32
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener ... servlet容器初始还");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener ... servlet容器关闭.......");

    }
}
