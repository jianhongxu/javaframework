package cm.xjh.config;

import cm.xjh.service.UserService;
import cm.xjh.servlet.UserFilter;
import cm.xjh.servlet.UserListener;
import cm.xjh.servlet.UserServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @autor xujianhong
 * @date 2020/1/30 22:03
 */

//在方法onStartup 中 Set集合里装的全部是UserService的子接口或者子的实现类

/**
 * 使用servletContext来添加 组建
 *   必须是在servlet容器各个启动的时候可以添加
 *     有两种方式：
 *     1、使用ServletContainerInitializer的方式
 *     2、使用ServletContextListener监听器的这种方式
 *
 */
@HandlesTypes(value = {UserService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        System.out.println("容器启动....MyServletContainerInitializer");
        for(Class c : set){
            System.out.println(c);
        }

        //使用ServletContext来注册  servlet/ filter/ listener
        ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
        servlet.addMapping("/user");

        //添加listeer
        sc.addListener(UserListener.class);

        //添加filter
        FilterRegistration.Dynamic dynamic = sc.addFilter("userFilter", UserFilter.class);
        dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
