package com.dk.learndemo.designpattern.adapter.clazzadapter;

/**
 * @Description : Adapter
 * 类适配器类
 * @Date : 2019/11/28
 * @Author : zhudakang
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 使用适配器实现目标对象的方法。
     */
    @Override
    public void request() {
        specificRequest();
    }
}
