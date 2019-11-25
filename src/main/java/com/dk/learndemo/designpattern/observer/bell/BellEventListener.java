package com.dk.learndemo.designpattern.observer.bell;

import java.util.EventListener;

/**
 * @Description : BellEventListener
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public interface BellEventListener extends EventListener {

    //事件处理方法，听到铃声
    void heardBell(RingEvent e);
}
