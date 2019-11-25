package com.dk.learndemo.designpattern.observer.bell;

/**
 * @Description : TeachEventListener
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class TeachEventListener implements BellEventListener {

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}
