package com.xjh.myspringboot.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @autor xujianhong
 * @date 2020/2/2 22:04
 * Accept-Language 根据这个获取区域信息
 */
public class MyLocalesolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        Locale locale = Locale.getDefault();

        //l是前端页面设置的属性值 l=en_US l=zh_CN
        String l = request.getParameter("l");
        if(null != l){
           String[] ls = l.split("_");
            locale = new Locale(ls[0], ls[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
