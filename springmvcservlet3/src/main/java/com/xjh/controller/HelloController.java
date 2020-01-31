package com.xjh.controller;

import com.xjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @autor xujianhong
 * @date 2020/1/31 23:53
 */
@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
       return userService.sayHello();
    }

    @RequestMapping("/jsppage")
    public String jsppage(){
        return "success";
    }

}
