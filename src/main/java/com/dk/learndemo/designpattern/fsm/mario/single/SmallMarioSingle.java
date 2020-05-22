package com.dk.learndemo.designpattern.fsm.mario.single;

import com.dk.learndemo.designpattern.fsm.mario.State;

/**
 * @author :zhudakang
 * @description : SmallMarioSingle
 * @create : 2020/05/22
 */
public class SmallMarioSingle implements IMarioSingle {

    private static final SmallMarioSingle instance = new SmallMarioSingle();

    private SmallMarioSingle() {
    }

    public static SmallMarioSingle getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachineSingle stateMachine) {
        stateMachine.setCurrentState(SuperMarioSingle.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void meetMonster(MarioStateMachineSingle stateMachine) { // do nothing... }}
    }
}
