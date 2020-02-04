package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @autor xujianhong
 * @date 2020/2/4 10:36
 */
@Component
public class CacheAutowaried  {

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}

