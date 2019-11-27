package com.dk.learndemo.designpattern.mediator.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : SimpleMediator
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class SimpleMediator {
    private static SimpleMediator smd = new SimpleMediator();
    private List<SimpleColleague> colleagues = new ArrayList<>();

    private SimpleMediator() {
    }

    public static SimpleMediator getMedium() {
        return (smd);
    }

    public void register(SimpleColleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }

    public void relay(SimpleColleague scl) {
        for (SimpleColleague ob : colleagues) {
            if (!ob.equals(scl)) {
                ((SimpleColleague) ob).receive();
            }
        }
    }
}
