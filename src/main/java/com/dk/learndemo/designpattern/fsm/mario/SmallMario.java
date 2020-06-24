package com.dk.learndemo.designpattern.fsm.mario;

/**
 * @author :zhudakang
 * @description : SmallMario 可以将状态类设计成单例
 *                 为什么考虑设计成单例，因为他不包含任何成员变量
 *
 * @create : 2020/05/22
 */
public class SmallMario implements IMario {

    private MarioStateMachine stateMachine;

    public SmallMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

//    @Override
//    public void obtainCape() {
//        stateMachine.setCurrentState(new CapeMario(stateMachine));
//        stateMachine.setScore(stateMachine.getScore() + 200);
//    }
//
//
//    @Override
//    public void obtainFireFlower() {
//        stateMachine.setCurrentState(new FireMario(stateMachine));
//        stateMachine.setScore(stateMachine.getScore() + 300);
//    }

    @Override
    public void meetMonster() {
        // do nothing...
    }
}