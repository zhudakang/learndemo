package com.dk.learndemo.proxy.demo1;

/**
 * @Author : zhudakang
 * @Description : Petter
 * @Date : 2019/7/31
 */
public class Petter implements MeetAgency {

    @Override
    public void canHelpSign() {
        System.out.println("peter可以帮忙签到！");
    }
}
