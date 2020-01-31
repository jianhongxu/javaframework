package com.xjh.interceptors;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @autor xujianhong
 * @date 2020/2/1 1:34
 */
public class DeferredResultQueue {

    private static Queue<DeferredResult<Object>> queues = new ConcurrentLinkedDeque<>();

    public static void setQueues(DeferredResult<Object> deferredResult){
        queues.add(deferredResult);
    }

    public static DeferredResult<Object> get(){
        return  queues.poll();
    }
}
