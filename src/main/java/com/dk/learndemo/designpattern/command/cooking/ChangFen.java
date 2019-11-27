package com.dk.learndemo.designpattern.command.cooking;

/**
 * @Description : ChangFen
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ChangFen implements Breakfast {
    private ChangFenChef receiver;

    ChangFen() {
        receiver = new ChangFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}
