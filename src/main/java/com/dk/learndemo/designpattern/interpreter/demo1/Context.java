package com.dk.learndemo.designpattern.interpreter.demo1;

/**
 * @Description : Context
 *                环境类
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class Context {

    private AbstractExpression exp;

    public Context() {
        //数据初始化
    }

    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}
