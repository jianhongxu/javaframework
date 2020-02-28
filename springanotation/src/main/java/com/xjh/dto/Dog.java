package com.xjh.dto;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @autor xujianhong
 * @date 2020/1/27 20:32
 */

@Component
public class Dog  {


    @PostConstruct
    public void destroy() {
        System.out.println("注解@PostConstruct的方式实现相当与destroy()方法............DOG ");
    }

    @PreDestroy
    public void afterPropertiesSet() {
        System.out.println("注解@PostConstruct的方式实现相当与init()方法...........DOG ");
    }

}
