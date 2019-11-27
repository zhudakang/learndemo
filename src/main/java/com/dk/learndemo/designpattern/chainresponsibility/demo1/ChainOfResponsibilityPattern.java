package com.dk.learndemo.designpattern.chainresponsibility.demo1;

/**
 * @Description : ChainOfResponsibilityPattern
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("two");
    }
}
