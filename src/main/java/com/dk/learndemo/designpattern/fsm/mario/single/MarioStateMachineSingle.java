package com.dk.learndemo.designpattern.fsm.mario.single;

import com.dk.learndemo.designpattern.fsm.mario.State;

/**
 * @author :zhudakang
 * @description : MarioStateMachineSingle
 * @create : 2020/05/22
 */
public class MarioStateMachineSingle {

    private int score;
    private IMarioSingle currentState;

    public MarioStateMachineSingle() {
        this.score = 0;
        this.currentState = SmallMarioSingle.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMarioSingle currentState) {
        this.currentState = currentState;
    }
}
