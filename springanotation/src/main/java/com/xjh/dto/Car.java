package com.xjh.dto;

import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:16
 *
 * 配置文件中指定了car的初始化和销毁方法
 * com.xjh.config.MainConfig#car()
 */
public class Car {

    private String name;
    private Integer age;

    public Car() {
        System.out.println("car的构造方法...");
        this.name = "小狗";
        this.age = 36;
    }

    public void init(){
        System.out.println("car的初始化方法init............Car");
    }

    public void destory(){
        System.out.println("car的销毁方法destory............Car");
    }
}
