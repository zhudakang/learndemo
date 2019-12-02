package com.dk.learndemo.designpattern.interpreter.demo1;

/**
 * @Description : NonterminalExpression //非终结符表达式类
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class NonterminalExpression implements AbstractExpression {

    private AbstractExpression exp1;
    private AbstractExpression exp2;

    @Override
    public Object interpret(String info) {
        //非对终结符表达式的处理
        return new Object();
    }
}
