package com.xjh.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/29 16:25
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("监听器监听到的事件: "+ event);
    }
}
