package com.dk.learndemo.designpattern.observer.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者 抽象方法
 * 对象发生变化，要通知观察者。
 */
abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者方法
     * 或者说是注册 attach 符合书上的所说
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者方法
     * 也可以说是注销 detach
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver(String newState) {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");
        for (Object obs : observers) {
            ((Observer) obs).update(newState);
        }
    }

}
