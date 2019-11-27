package com.dk.learndemo.designpattern.command.demo;

/**
 * @Description : CommandPattern
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class CommandPattern {

    /**
     * 相当于将命令与调用者和执行者分开
     * 调用者可以执行继承Command接口的类
     * 所以调用者可以去执行各种命令
     * 把命令传给执行者
     * */
    public static void main(String[] args) {
        Command cmd = new ConcreteCommand();
        //放入要调用的命令
        Invoker ir = new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        //让调用者执行命令call
        //receiver.action() 被执行
        ir.call();
    }
}
