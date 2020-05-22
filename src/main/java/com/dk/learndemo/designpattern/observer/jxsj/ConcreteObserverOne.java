package com.dk.learndemo.designpattern.observer.jxsj;

/**
 * @author :zhudakang
 * @description : ConcreteObserverOne
 * @create : 2020/05/22
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        //notified 通知
        System.out.println("ConcreteObserverOne is notified. Msg is " + message.getMsg());
    }
}
