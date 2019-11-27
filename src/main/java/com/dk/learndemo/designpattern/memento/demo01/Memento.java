package com.dk.learndemo.designpattern.memento.demo01;

/**
 * @Description : Memento
 *                备忘录
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
