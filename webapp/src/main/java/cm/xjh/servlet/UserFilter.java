package cm.xjh.servlet;


import javax.servlet.*;
import java.io.IOException;

/**
 * @autor xujianhong
 * @date 2020/1/31 22:40
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("UserFilter...init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getServletContext().getContextPath());
        System.out.println("UserFilter...doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("UserFilter...destroy");
    }
}
