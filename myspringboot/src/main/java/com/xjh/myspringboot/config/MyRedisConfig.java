package com.xjh.myspringboot.config;

import com.xjh.myspringboot.enetity.CacheEmp;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @autor xujianhong
 * @date 2020/2/4 23:50
 */

@Configuration
@ConfigurationProperties(prefix = "spring.cache.redis")
public class MyRedisConfig {

    /**
     * 改变redistemplate默认的序列化机制
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, CacheEmp> myRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, CacheEmp> result = new RedisTemplate<String, CacheEmp>();
        result.setConnectionFactory(redisConnectionFactory);
        //设置序列化器 jsck序列化
        Jackson2JsonRedisSerializer<CacheEmp> cacheEmpJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<CacheEmp>(CacheEmp.class);
        result.setDefaultSerializer(cacheEmpJackson2JsonRedisSerializer);
        return result;
    }

    /**
     * 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);

        //设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));

        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }


}


