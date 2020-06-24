package com.dk.learndemo.designpattern.observer.jxsj;

/**
 * @author :zhudakang
 * @description : Subject
 * @create : 2020/05/22
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(Message message);
}
