package com.dk.learndemo.aop.cglib;

/**
 * @author :zhudakang
 * @description : AgentServiceImpl
 * @create : 2020/03/18
 */
public class AgentServiceImpl {
    public String addAgent(String name) {
        System.out.println("agent name ：" + name);
        return name;
    }
}
