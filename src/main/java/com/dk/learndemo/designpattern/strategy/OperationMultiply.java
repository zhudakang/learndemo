package com.dk.learndemo.designpattern.strategy;

/**
 * @author :zhudakang
 * @description : OperationMultiply
 * @create : 2020/08/13
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
