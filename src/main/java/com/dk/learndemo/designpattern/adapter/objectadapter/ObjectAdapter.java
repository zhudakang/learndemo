package com.dk.learndemo.designpattern.adapter.objectadapter;

import com.dk.learndemo.designpattern.adapter.clazzadapter.Adaptee;
import com.dk.learndemo.designpattern.adapter.clazzadapter.Target;

/**
 * @Description : ObjectAdapter 对象适配器类
 * @Date : 2019/11/28
 * @Author : zhudakang
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
