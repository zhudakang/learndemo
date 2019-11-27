package com.dk.learndemo.designpattern.mediator.simple;

/**
 * @Description : SimpleMediatorPattern
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class SimpleMediatorPattern {
    public static void main(String[] args) {
        SimpleColleague c1, c2;
        c1 = new SimpleConcreteColleague1();
        c2 = new SimpleConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }
}
