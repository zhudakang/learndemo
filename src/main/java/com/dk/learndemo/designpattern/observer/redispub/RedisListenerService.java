package com.dk.learndemo.designpattern.observer.redispub;

public interface RedisListenerService {
    void clearUserCache(String key);

    void releaseOrder(String key);
}
