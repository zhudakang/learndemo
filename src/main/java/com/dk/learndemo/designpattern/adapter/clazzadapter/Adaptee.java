package com.dk.learndemo.designpattern.adapter.clazzadapter;

/**
 * @Description : Adaptee
 *                适配者
 * @Date : 2019/11/28
 * @Author : zhudakang
 */
public class Adaptee {
    public void specificRequest() {
        System.out.println("适配者中的业务代码被调用！");
    }
}
