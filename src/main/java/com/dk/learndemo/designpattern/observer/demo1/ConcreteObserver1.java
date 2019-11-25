package com.dk.learndemo.designpattern.observer.demo1;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description : ConcreteObserver1
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
@Slf4j
public class ConcreteObserver1 implements Observer {

    //观察者状态
    private String observerState;

    @Override
    public void update(String newState) {
        //更新观察者状态，让它与目标状态一致
        observerState = newState;
        System.out.println("接收到消息：" + newState + "；A模块更新开始秒杀！");
    }
}
