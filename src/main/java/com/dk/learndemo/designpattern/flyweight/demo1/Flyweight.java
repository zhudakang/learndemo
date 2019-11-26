package com.dk.learndemo.designpattern.flyweight.demo1;

/**
 * 抽象享元角色
 */
public interface Flyweight {

    public void operation(UnsharedConcreteFlyweight state);

}
