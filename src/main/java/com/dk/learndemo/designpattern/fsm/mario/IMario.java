package com.dk.learndemo.designpattern.fsm.mario;

/**
 * @author :zhudakang
 * @description : IMario
 * @create : 2020/05/22
 */
public interface IMario {
    State getName(); //以下是定义的事件
    void obtainMushRoom();
//    void obtainCape();
//    void obtainFireFlower();
    void meetMonster();
}
