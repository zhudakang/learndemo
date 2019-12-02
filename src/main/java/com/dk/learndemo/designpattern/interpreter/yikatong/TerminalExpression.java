package com.dk.learndemo.designpattern.interpreter.yikatong;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description : TerminalExpression 终结符表达式类
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class TerminalExpression implements Expression {

    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) set.add(data[i]);
    }

    @Override
    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}
