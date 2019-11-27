package com.dk.learndemo.designpattern.mediator.demo1;

/**
 * @Description : Mediator
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
