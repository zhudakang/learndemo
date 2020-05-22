package com.dk.learndemo.designpattern.fsm.mario;

/**
 * @author :zhudakang
 * @description : State
 * @create : 2020/05/22
 */
public enum State {

    SMALL(0), SUPER(1), FIRE(2), CAPE(3);
    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
