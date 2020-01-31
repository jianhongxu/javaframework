package cm.xjh.servlet;

import cm.xjh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor xujianhong
 * @date 2020/1/30 21:53
 *
 * 可以用下面的三个注解 分别创建三大组件
 * @WebListener
 * @WebFilter
 * @WebServlet("/hello")
 *
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Thread.currentThread()+".............start");
        sayHello();
        resp.getWriter().write("hello serlvert。。。。。");
        System.out.println(Thread.currentThread()+".............end");
    }


    public void sayHello(){
        try {
            System.out.println(Thread.currentThread()+"处理逻辑");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
