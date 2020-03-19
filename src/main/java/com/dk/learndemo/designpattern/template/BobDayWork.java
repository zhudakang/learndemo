package com.dk.learndemo.designpattern.template;

/**
 * @author :zhudakang
 * @description : BobDayWork
 * @create : 2020/03/19
 */
public class BobDayWork extends DayWorkTemplate {

    @Override
    public void goToWork() {
        System.out.println("开车上班");
    }

    /**
     * 工作中
     */
    @Override
    public void working() {
        System.out.println("划水");
    }

    /**
     * 下班
     */
    @Override
    public void getOffWork() {
        System.out.println("开车下班");
    }

    ;

}
