package com.xjh.myspringboot.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @autor xujianhong
 * @date 2020/2/6 19:35
 */

@Service
public class AsyncTaskServiec {

    //标注为异步任务
    @Async
    public void handleTask(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务处理中");
    }
}
