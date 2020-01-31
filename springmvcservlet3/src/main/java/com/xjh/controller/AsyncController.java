package com.xjh.controller;

import com.xjh.interceptors.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @autor xujianhong
 * @date 2020/2/1 1:09
 */

@Controller
public class AsyncController {

    /**
     *异步拦截器：
     *       1、原生的 AsyncListener
     *       2、 spring mvc的
     *
     * @return
     */
    @RequestMapping("/async")
    @ResponseBody
    public Callable<String> async(){
        System.out.println("主线程start..."+Thread.currentThread()+"............."+System.currentTimeMillis());
        Callable callable =   new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("子线程start..."+Thread.currentThread()+"............."+System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("子线程end..."+Thread.currentThread()+"............."+System.currentTimeMillis());
                return "String async......";
            }
        };
        System.out.println("主线程end..."+Thread.currentThread()+"............."+System.currentTimeMillis());
        return callable;
    }


    /**
     * spring 异步的方式  DeferredResult 在别的线程设值的时候 会触发返回视图
     *  下面的两个方法是模拟创建订单的逻辑   服务1调用  服务1调用服务2创建订单  当服务二返回结果 并且将结果设置到DeferredResult对象中的时候 createOrder方法就会返回
     * @return
     */
    @RequestMapping("/createOrder")
    @ResponseBody
    public DeferredResult<Object> async02(){
        DeferredResult<Object> result = new DeferredResult<Object>((long)4000, " create order fail");
        DeferredResultQueue.setQueues(result);
        return result;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(){
        String orderId = UUID.randomUUID().toString();
        DeferredResultQueue.get().setResult(orderId);
        return "success 订单的编号是 ： "+orderId;
    }
}
