package com.dk.learndemo.designpattern.flyweight.demo1;

/**
 * @Description : ConcreteFlyweight
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class ConcreteFlyweight implements Flyweight {

    private String key;

    ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedConcreteFlyweight outState) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + outState.getInfo());
    }

}
