package com.dk.learndemo.designpattern.mediator.demo1;

/**
 * @Description : Colleague
 *                抽象同事类, 但是在这种情况下，只能用抽象类，而不能用接口。因为中介属性是作为内部属性存在于同事类的父类的。
 *                所以用抽象类比较合理。
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public abstract class Colleague {

    protected Mediator mediator;

    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}
