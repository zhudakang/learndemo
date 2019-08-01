package com.dk.learndemo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhudakang
 * @Description : Monitor
 * 线程调用方法前，需要提前获取到Condition对象关联的锁。（注意点就在与需要调用之前提前获取到锁）
 * 公平锁的效率没有非公平的高，但是并不是任何场景都是以TPS作为唯一指标（并不一定所有场景都是吞吐量越高越好效率高）
 * 公平锁能够减少饥饿发生的概率，等待越久越能够得到优先满足
 * TPS是什么？  系统吞吐量
 *
 *
 * @Date: 2019/5/30 17:31
 */
public class ConditionUseCase {

    Lock lock = new ReentrantLock();
    //Condition是依赖于lock的
    Condition condition = lock.newCondition();
}
