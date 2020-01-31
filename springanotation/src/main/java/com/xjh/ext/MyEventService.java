package com.xjh.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/29 16:48
 */
@Component
public class MyEventService {


    @EventListener({ApplicationEvent.class})
    public void listener(ApplicationEvent event){
        System.out.println("MyEventService 的普通方法监听到事件： "+event);
    }
}
