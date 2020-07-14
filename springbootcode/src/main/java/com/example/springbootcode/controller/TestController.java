package com.example.springbootcode.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/13 21:30
 * @Description:
 */

@Controller
@RequestMapping("/demo")
public class TestController {

    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(){
        System.out.println("调用控制器..");
        return new User();
    }

    @RequestMapping("/test2.do")
    @ResponseBody
    public Object test2(){
        System.out.println("调用控制器..2");
        return new User();
    }
}

@Data
class User{
    private String name;
    private int age;
}