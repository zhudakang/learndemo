package com.dk.learndemo.designpattern.memento.demo01;

/**
 * @Description : Originator
 *                发起人
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
