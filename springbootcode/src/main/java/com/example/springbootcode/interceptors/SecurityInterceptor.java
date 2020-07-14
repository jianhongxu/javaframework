package com.example.springbootcode.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Tile: springMVC的拦截器
 * @Autor: xujianhong
 * @Date: 2020/7/14 11:05
 * @Description: springMVC的拦截器
 */
public class SecurityInterceptor implements HandlerInterceptor {

    /**
     * 在真实handler 执行前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("before我是拦截器......执行之前被执行了");
        return true;
    }

    /**
     * 在真实handler执行之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("after我是拦截器......handler执行之后被执行了");
    }

    /**
     * Callback after completion of request processing, that is, after renderingthe view.
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterafterafter视图渲染之前 拦截执行");
    }
}
