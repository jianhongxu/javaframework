package com.xjh.myspringboot.config;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import com.xjh.myspringboot.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor xujianhong
 * @date 2020/2/1 22:54
 */

@Configuration//指定这是一个配置类
public class MyConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    }


}
