package com.dk.learndemo.designpattern.command.cooking;

/**
 * @Description : HunTun
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class HunTun implements Breakfast {
    private HunTunChef receiver;

    HunTun() {
        receiver = new HunTunChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}
