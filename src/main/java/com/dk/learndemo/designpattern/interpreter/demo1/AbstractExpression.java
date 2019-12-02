package com.dk.learndemo.designpattern.interpreter.demo1;

/**
 * @Description : AbstractExpression 抽象表达式类
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public interface AbstractExpression {
    /**
     * 解释方法
     * */
    public Object interpret(String info);
}
