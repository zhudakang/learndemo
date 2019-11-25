package com.dk.learndemo.designpattern.observer.demo1;

/**
 * @Description : ConcreteSubject
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void change(String newState) {
        state = newState;
        //状态发生改变，通知观察者
        notifyObserver(newState);
    }
}
