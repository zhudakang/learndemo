package com.dk.learndemo.designpattern.command.cooking;

/**
 * @Description : Waiter
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class Waiter {

    private Breakfast changFen, hunTun, heFen;

    public void setChangFen(Breakfast f) {
        changFen = f;
    }

    public void setHunTun(Breakfast f) {
        hunTun = f;
    }

    public void setHeFen(Breakfast f) {
        heFen = f;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }

    public void chooseHunTun() {
        hunTun.cooking();
    }

    public void chooseHeFen() {
        heFen.cooking();
    }
}
