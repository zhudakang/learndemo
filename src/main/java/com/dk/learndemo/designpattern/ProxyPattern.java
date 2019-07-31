package com.dk.learndemo.designpattern;

/**
 * @Author : zhudakang
 * @Description : ProxyPattern 代理模式的学习，代理模式作为最重要的一种模式，也是最常见的
 *                代理模式的话，被代理的类和代理类之间有这共同的接口，被代理类不与客户直接接触。
 *                优点解耦合，降低了不同类之间的依赖性！
 * @Date : 2019/7/31
 */
public class ProxyPattern {


    public static void main(String[] args) {

        Brother brother =  new Brother();
        Bob bob = new Bob();
        Petter petter  = new Petter();
        brother.setEatAgency(bob);
        //将代理类注入进去~通过代理来接触到客户/想实现的目的（meet签字）
        brother.setMeetAgency(petter);
        //其实就是不自己干，交给别人干，帮自己实现目的
        brother.eat();
        brother.meet();
    }




}
