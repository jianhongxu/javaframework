package com.xjh.myspringboot.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @autor xujianhong
 * @date 2020/2/5 23:31
 */
@Configuration
public class RabbitmqConfig {

    /**
     * 默认rabbitmq使用的是jdk的序列化对象
     * 设置为json的序列化方式
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        MessageConverter messageConverter = new Jackson2JsonMessageConverter();

        return messageConverter;
    }

}
