package com.dk.learndemo.designpattern.command.cooking;

/**
 * @Description : HeFen
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class HeFen implements Breakfast {
    private HeFenChef receiver;

    HeFen() {
        receiver = new HeFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}
