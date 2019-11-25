package com.dk.learndemo.designpattern.observer.demo1;

/**
 * @Description : ObserverPattern
 *
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        //有两个观察者
        Observer obs1 = new ConcreteObserver1();
        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver("倒计时结束");
    }
}
