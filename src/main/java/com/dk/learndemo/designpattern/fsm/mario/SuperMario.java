package com.dk.learndemo.designpattern.fsm.mario;

/**
 * @author :zhudakang
 * @description : SuperMario
 * @create : 2020/05/22
 */
public class SuperMario implements IMario {


    private MarioStateMachine stateMachine;


    public SuperMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom() { // do nothing... }
    }

    @Override
    public void meetMonster() {
        //遇到怪兽变成小的马里奥
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
