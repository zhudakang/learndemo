package com.dk.learndemo.designpattern.fsm.mario.single;

import com.dk.learndemo.designpattern.fsm.mario.State;

/**
 * @author :zhudakang
 * @description : IMarioSingle
 * @create : 2020/05/22
 */
public interface IMarioSingle {
    State getName();
    void obtainMushRoom(MarioStateMachineSingle stateMachine);
    void meetMonster(MarioStateMachineSingle stateMachine);
}
