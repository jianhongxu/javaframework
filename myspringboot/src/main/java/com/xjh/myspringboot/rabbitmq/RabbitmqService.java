package com.xjh.myspringboot.rabbitmq;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @autor xujianhong
 * @date 2020/2/5 23:46
 */

@Service
public class RabbitmqService {

   /*  只教授消息实体的方式...
   @RabbitListener(queues = {"xjh"})
    public void testMessages(CacheEmp cacheEmp){
        System.out.println("收到的消息是:............."+cacheEmp);
    }*/

    @RabbitListener(queues = {"xjh"})
    public void testMessagesMessage(Message message){
        System.out.println("收到的消息是:............."+message.getMessageProperties()+"=="+message.getBody());
    }
}
