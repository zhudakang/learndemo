package com.dk.learndemo.designpattern.mediator.demo1;

/**
 * @Description : MediatorPattern
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleague1();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        //让c1发送一则消息，通过中介，传递给所有在此中介处的同事
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
