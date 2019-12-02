package com.dk.learndemo.designpattern.interpreter.yikatong;

/**
 * @Description : AndExpression 非终结符表达式类
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class AndExpression implements Expression {

    private Expression city = null;
    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    /**
     * 将的分割，
     *  得到两个前后的城市和人员
     * */
    @Override
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
