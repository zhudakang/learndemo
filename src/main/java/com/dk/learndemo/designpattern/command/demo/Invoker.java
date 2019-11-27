package com.dk.learndemo.designpattern.command.demo;

/**
 * @Description : Invoker
 *                调用者
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}
