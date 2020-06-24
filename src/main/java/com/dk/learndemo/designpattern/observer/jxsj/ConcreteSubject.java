package com.dk.learndemo.designpattern.observer.jxsj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : ConcreteSubject
 *                  只是大体的设计思路；
 *                  真实开发会很多样化
 * @create : 2020/05/22
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) { observers.add(observer); }

    @Override
    public void removeObserver(Observer observer) { observers.remove(observer); }

    /**
     * 进行更新
     * */
    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /**
     * 标准的观察者模式的方法
     * 1.初始化
     * 2.注册要被观察的
     * 3.通知更新
     * 4.销毁之类
     * 发布订阅模式，main方法相当于发布者，所有订阅的都接受到消息并更新
     * 真正的业务代码里面，有时候不会完全遵守接口/方法的单一职责，因为会过渡设计反而带来更多复杂性。
     * */
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message("message 1"));
        subject.notifyObservers(new Message("message 2"));
    }
}
