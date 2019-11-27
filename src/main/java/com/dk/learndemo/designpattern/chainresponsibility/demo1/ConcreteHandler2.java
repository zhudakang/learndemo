package com.dk.learndemo.designpattern.chainresponsibility.demo1;

/**
 * @Description : ConcreteHandler2
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("具体处理者2负责处理该请求！");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
