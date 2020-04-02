package com.dk.learndemo.designpattern.template;

/**
 * @author :zhudakang
 * @description : PeterDayWork
 * @create : 2020/03/19
 */
public class PeterDayWork extends DayWorkTemplate {

    @Override
    public void goToWork() {
        System.out.println("乘坐公交");
    }

    /**
     * 工作中
     */
    @Override
    public void working() {
        System.out.println("努力工作");
    }

    /**
     * 下班
     */
    @Override
    public void getOffWork() {
        System.out.println("乘坐地铁");
    }
}
