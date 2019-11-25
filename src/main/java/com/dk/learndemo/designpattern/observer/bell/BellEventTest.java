package com.dk.learndemo.designpattern.observer.bell;

/**
 * @Description : BellEventTest
 * @Date : 2019/11/25
 * @Author : zhudakang
 */
public class BellEventTest {

    public static void main(String[] args) {
        BellEventSource bell = new BellEventSource();    //铃（事件源）
        bell.addPersonListener(new TeachEventListener()); //注册监听器（老师）
        bell.addPersonListener(new StuEventListener());    //注册监听器（学生）
        bell.ring(true);   //打上课铃声
        System.out.println("------------");
        bell.ring(false);  //打下课铃声
    }
}
