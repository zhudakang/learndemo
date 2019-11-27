package com.dk.learndemo.designpattern.memento.demo01;

/**
 * @Description : Caretaker
 *                管理者
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class Caretaker {
    private Memento memento;

    public void setMemento(Memento m) {
        memento = m;
    }

    public Memento getMemento() {
        return memento;
    }
}
