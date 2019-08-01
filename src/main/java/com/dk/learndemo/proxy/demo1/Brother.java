package com.dk.learndemo.proxy.demo1;

/**
 * @Author : zhudakang
 * @Description : Brother
 * @Date : 2019/7/31
 */
public class Brother {

    private EatAgency eatAgency;
    private MeetAgency meetAgency;

    public EatAgency getEatAgency() {
        return eatAgency;
    }

    public void setEatAgency(EatAgency eatAgency) {
        this.eatAgency = eatAgency;
    }

    public MeetAgency getMeetAgency() {
        return meetAgency;
    }

    public void setMeetAgency(MeetAgency meetAgency) {
        this.meetAgency = meetAgency;
    }

    void eat() {
        //需要找代理喂饭
        eatAgency.canHelpBuyFood();
    }

    void meet() {
        //需要找代理洗衣服
        meetAgency.canHelpSign();
    }
}
