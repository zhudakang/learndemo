package com.dk.learndemo.spring.templatemethod;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author :zhudakang
 * @description : RedisTest
 * @create : 2020/03/19
 */
public class TemplateTest {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 增加spring-amqp依赖
     *
     * */
    @Autowired
    AmqpTemplate amqpTemplate;
}
