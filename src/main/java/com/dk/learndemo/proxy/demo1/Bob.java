package com.dk.learndemo.proxy.demo1;

/**
 * @Author : zhudakang
 * @Description : Bob can buy food
 * @Date : 2019/7/31
 */
public class Bob implements EatAgency {

    @Override
    public void canHelpBuyFood() {
        System.out.println("bob可以带饭");
    }
}
