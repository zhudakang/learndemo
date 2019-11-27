package com.dk.learndemo.designpattern.command.demo;

/**
 * @Description : ConcreteCommand
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
