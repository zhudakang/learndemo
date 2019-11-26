package com.dk.learndemo.designpattern.observer.redispub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @Description : RedisListenerConfig
 *                使用监听模式，java server会持续的进行监听
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
@Slf4j
@Configuration
public class RedisListenerConfig {

    @Value("${redis.pattern-topic}")
    private String patternTopic;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //监听所有db的过期事件__keyevent@*__:expired"
        //__keyevent@*__:expired  这里面的*是db的号码
        //用于添加redis的监听者，这种属于模式订阅
        container.addMessageListener(new RedisExpiredListener(), new PatternTopic(patternTopic));
        return container;
    }
}
