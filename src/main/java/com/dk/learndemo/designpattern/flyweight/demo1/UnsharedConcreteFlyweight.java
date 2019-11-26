package com.dk.learndemo.designpattern.flyweight.demo1;

/**
 * @Description : UnsharedConcreteFlyweight
 * 并不共享的东西，通过参数传入
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class UnsharedConcreteFlyweight {

    private String info;

    UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
