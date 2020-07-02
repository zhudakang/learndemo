package com.dk.learndemo.spring.templatemethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

/**
 * @author :zhudakang
 * @description : RedisTest
 * @create : 2020/03/19
 */
public class TemplateTest {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 原始的jedis实现
     * 但是springboot只要实现一个RedisConfig和对应的Redis配置就好
     * */
    public void test(){
        // 1.封装config
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(20);
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxWaitMillis(2000);
        // 2.创建jedis池
        Pool<Jedis> pools = new JedisPool(poolConfig,"localhost",6379,2000,null,false);
        // 3.获取jedis
        Jedis jedis = pools.getResource();
        // 4.jedis操作
        jedis.set("name".getBytes(), "lucy".getBytes());
        boolean exists = jedis.exists("name");
        System.out.println(exists);
    }
}
