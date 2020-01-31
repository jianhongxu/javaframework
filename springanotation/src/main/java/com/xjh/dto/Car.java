package com.xjh.dto;

import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:16
 */
public class Car {

    public Car() {
        System.out.println("初始化...");
    }

    public void init(){
        System.out.println("init............Car");
    }

    public void destory(){
        System.out.println("destory............Car");
    }
}
