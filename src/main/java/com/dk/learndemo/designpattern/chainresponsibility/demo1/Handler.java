package com.dk.learndemo.designpattern.chainresponsibility.demo1;

/**
 * @Description : Handler
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public abstract class Handler {

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    /**
     * 处理请求的方法
     */
    public abstract void handleRequest(String request);
}
