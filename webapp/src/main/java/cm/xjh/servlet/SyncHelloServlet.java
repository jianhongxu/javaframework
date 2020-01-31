package cm.xjh.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor xujianhong
 * @date 2020/2/1 0:53
 *
 * servlet3.0 异步处理的方法
 */
@WebServlet(value = "/snyc",asyncSupported = true)
public class SyncHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程"+ Thread.currentThread()+".............start");

        //开始异步处理
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程"+ Thread.currentThread()+".............start");
                sayHello();
                //异步处理完成
                asyncContext.complete();
                try {
                    asyncContext.getResponse().getWriter().write("hello serlvert。。。。。");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+ Thread.currentThread()+".............end");
            }
        });

        System.out.println("主线程"+ Thread.currentThread()+".............end");
    }


    public void sayHello(){
        try {
            System.out.println(Thread.currentThread()+"处理逻辑");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
