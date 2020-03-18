package com.dk.learndemo.aop.cglib;

/**
 * @author :zhudakang
 * @description : AgentServiceImpl
 * @create : 2020/03/18
 */
public class AgentServiceImpl {
    public String addAgent(String name) {
        System.out.println("新增代理人：" + name);
        return name;
    }
}
