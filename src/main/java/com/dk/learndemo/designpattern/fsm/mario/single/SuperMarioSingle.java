package com.dk.learndemo.designpattern.fsm.mario.single;

import com.dk.learndemo.designpattern.fsm.mario.State;

/**
 * @author :zhudakang
 * @description : SuperMarioSingle
 * @create : 2020/05/22
 */
public class SuperMarioSingle implements IMarioSingle {

    private static final SuperMarioSingle instance = new SuperMarioSingle();

    private SuperMarioSingle() {
    }

    public static SuperMarioSingle getInstance() {
        return instance;
    }

    private MarioStateMachineSingle stateMachine;

    public SuperMarioSingle(MarioStateMachineSingle stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom(MarioStateMachineSingle stateMachine) {
        stateMachine.setCurrentState(SuperMarioSingle.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void meetMonster(MarioStateMachineSingle stateMachine) {
        //遇到怪兽变成小的马里奥
        stateMachine.setCurrentState(SmallMarioSingle.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
