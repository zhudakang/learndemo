package com.dk.learndemo.designpattern.mediator.simple;

/**
 * @Description : SimpleConcreteColleague1
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class SimpleConcreteColleague1 implements SimpleColleague {
    SimpleConcreteColleague1() {
        SimpleMediator smd = SimpleMediator.getMedium();
        smd.register(this);
    }

    @Override
    public void receive() {
        System.out.println("具体同事类1：收到请求。");
    }

    @Override
    public void send() {
        SimpleMediator smd = SimpleMediator.getMedium();
        System.out.println("具体同事类1：发出请求...");
        smd.relay(this); //请中介者转发
    }
}
