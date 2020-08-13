package com.dk.learndemo.designpattern.strategy;

/**
 * @author :zhudakang
 * @description : OperationSubtract
 * @create : 2020/08/13
 */
public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
