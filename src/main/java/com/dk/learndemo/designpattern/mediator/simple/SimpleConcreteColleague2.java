package com.dk.learndemo.designpattern.mediator.simple;

/**
 * @Description : SimpleConcreteColleague2
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class SimpleConcreteColleague2 implements SimpleColleague {
    SimpleConcreteColleague2() {
        SimpleMediator smd = SimpleMediator.getMedium();
        smd.register(this);
    }


    @Override
    public void receive() {
        System.out.println("具体同事类2：收到请求。");
    }

    @Override
    public void send() {
        SimpleMediator smd = SimpleMediator.getMedium();
        System.out.println("具体同事类2：发出请求...");
        smd.relay(this); //请中介者转发
    }
}
