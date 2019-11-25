package com.dk.learndemo.designpattern.observer.demo1;

/**
 * @Description : ConcreteObserver2
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class ConcreteObserver2 implements Observer {

    //观察者状态
    private String observerState;

    @Override
    public void update(String newState) {
        //更新观察者状态，让它与目标状态一致
        observerState = newState;
        System.out.println("接收到消息：" + newState + "；B模块更新开始秒杀！");
    }
}
