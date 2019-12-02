package com.dk.learndemo.designpattern.interpreter.demo1;

/**
 * @Description : TerminalExpression
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class TerminalExpression implements AbstractExpression {

    @Override
    public Object interpret(String info) {
        //对终结符表达式的处理
        return new Object();
    }
}
