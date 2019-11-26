package com.dk.learndemo.designpattern.flyweight.demo1;

import java.util.HashMap;

/**
 * @Description : FlyweightFactory
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class FlyweightFactory {

    private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = (Flyweight) flyweights.get(key);
        if (flyweight != null) {
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        } else {
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key, flyweight);
        }
        return flyweight;
    }
}
