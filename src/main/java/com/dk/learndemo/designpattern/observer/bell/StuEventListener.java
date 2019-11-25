package com.dk.learndemo.designpattern.observer.bell;

/**
 * @Description : StuEventListener
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class StuEventListener implements BellEventListener {

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}
