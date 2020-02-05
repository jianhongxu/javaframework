package com.xjh.myspringboot;

import com.xjh.myspringboot.enetity.CacheEmp;
import com.xjh.myspringboot.service.EmpCacheService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Date;

/**
 * spring boot
 * 消息中间件 ampq协议 rabbitmq测试
 */
@SpringBootTest
public class AmpqTest {

    /**
     * rabbitmq的客户端
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 用该类可以创建 队列 创建exchange 等等
     */
    @Autowired
    private AmqpAdmin amqpAdmin;


    /**
     * 点对点发送
     * @throws Exception
     */
    @Test
    public void test01() throws Exception{
        //发送消息的第一种
        //send(String exchange, String routingKey, Message message)
        //rabbitTemplate.send();

        CacheEmp cacheEmp = new CacheEmp();
        cacheEmp.setUserName("用户名");
        cacheEmp.setAddress("重庆市渝中区....120号");
        cacheEmp.setUserBrithday(new Date());

        //第二种转换并发送...消息
        rabbitTemplate.convertAndSend("exchange.direct","xjh",cacheEmp);
        rabbitTemplate.convertAndSend("exchange.direct","xjh",cacheEmp);
    }




    @Test
    public void test02() throws Exception{
        System.out.println("AmqpAdmin。。。创建类的实例"+amqpAdmin);
        //amqpAdmin.declareQueue()
        //amqpAdmin.declareBinding();
        System.out.println(rabbitTemplate.receiveAndConvert("xjh"));
    }

}
