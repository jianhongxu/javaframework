package com.xjh.myspringboot.controller;

import com.xjh.myspringboot.exceptionhander.MyExcepiton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @autor xujianhong
 * @date 2020/2/1 20:51
 */

@Controller
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/user")
    public String user(String userCode){
        if("aa".equals(userCode)){
           throw new MyExcepiton();
        }
        return "user ... Controller";
    }

    @ResponseBody
    @RequestMapping("/query")
    public Map<String, Object> query(){
        List<Map<String, Object>> list =  jdbcTemplate.queryForList("select * from dept");
        return list.get(0);
    }

}
