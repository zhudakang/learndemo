package com.dk.learndemo.designpattern.interpreter.yikatong;

/**
 * @Description : Context
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class Context {

    private String[] citys = {"韶关", "广州"};
    private String[] persons = {"老人", "妇女", "儿童"};
    /**
     * 初始化的是一个And表达式 也就是非终结符表达式
     */
    private Expression cityPerson;

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    /**
     * 不在set里面的人员 不免费
     */
    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
        }
    }
}
