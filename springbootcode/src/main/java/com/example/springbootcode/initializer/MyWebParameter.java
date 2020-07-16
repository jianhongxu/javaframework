package com.example.springbootcode.initializer;

import javax.servlet.ServletContext;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/14 15:16
 * @Description:
 */
public class MyWebParameter implements IWebParameter {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        System.out.println("qidogn =======");
    }
}
