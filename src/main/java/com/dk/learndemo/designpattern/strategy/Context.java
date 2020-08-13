package com.dk.learndemo.designpattern.strategy;

/**
 * @author :zhudakang
 * @description : Context
 * @create : 2020/08/13
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
