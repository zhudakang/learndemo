package com.dk.learndemo.designpattern.observer.jxsj;

/**
 * @author :zhudakang
 * @description : ConcreteObserverTwo
 * @create : 2020/05/22
 */
public class ConcreteObserverTwo implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne is notified. Msg is " + message.getMsg());
    }
}

