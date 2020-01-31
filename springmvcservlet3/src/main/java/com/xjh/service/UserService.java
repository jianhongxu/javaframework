package com.xjh.service;

import org.springframework.stereotype.Service;

/**
 * @autor xujianhong
 * @date 2020/1/31 23:54
 */
@Service
public class UserService {

    public String sayHello(){
        System.out.println("hello.....UserService");
        return "hello.....UserService";
    }
}
