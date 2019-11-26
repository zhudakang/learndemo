package com.dk.learndemo.designpattern.observer.redispub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Description : RedisListenerServiceImpl
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
@Slf4j
public class RedisListenerServiceImpl implements RedisListenerService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *
     * */
    @Override
    public void clearUserCache(String key){
        if (RedisConstants.APP_VERSION_UPDATE.equals(key)) {
            Set<String> keys = matchKeys(RedisConstants.TOKEN + "*");
            log.info("[RedisListenerServiceImpl] app版本更新 key = {}; size = {}", key, keys.size());
            redisTemplate.delete(keys);
        }
    }

    /**
     * 因为业务中 订单在审核的时候需要加锁
     * 在一定时间之后释放掉，别人只能看
     * 释放的时间应该在失效的时候进行通知
     * */
    @Override
    public void releaseOrder(String key) {
        //判断是否是需要处理的订单前缀
        if (key.startsWith(RedisConstants.ORDER_QUALITY_AUDIT_LOCK_)) {
            //因为只知道失效
            //这样来获取的id
            String id = key.replace(RedisConstants.ORDER_QUALITY_AUDIT_LOCK_, "");
            //通过自增号来避免重复处理，这个时候已经得到订阅了，说明这个key已经没了
            boolean succ = redisTemplate.opsForValue().setIfAbsent(RedisConstants.ORDER_QUALITY_AUDIT_RELEASE_
                    + id, id, 60, TimeUnit.SECONDS);
            log.info("[RedisListenerServiceImpl] 释放订单 redis : {}, succ : {}", key, succ);
            if (succ) {
                //更新数据库，置为未锁定
            }

        }
    }

    /**
     * 模糊匹配
     */
    public Set<String> matchKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }
}
