package com.xjh.myspringboot.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @autor xujianhong
 * @date 2020/2/3 20:26
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter doFilter....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy....");
    }
}
