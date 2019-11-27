package com.dk.learndemo.designpattern.mediator.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : ConcreteMediator
 * 具体的中介者
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ConcreteMediator extends Mediator {

    private List<Colleague> colleagues = new ArrayList<Colleague>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void relay(Colleague cl) {
        for (Colleague ob : colleagues) {
            if (!ob.equals(cl)) {
                ((Colleague) ob).receive();
            }
        }
    }
}
