package com.dk.learndemo.dynamicproxy.jdk;

import com.dk.learndemo.proxy.demo2.IFindWork;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author : zhudakang
 * @Description : ProxyFactory
 * @Date : 2019/8/1
 */
public class ProxyFactory {

    public static Object getDynProxy(Object target) {
        InvocationHandler handler = new DynProxyAgency(target);
        //这边使用java自带的Proxy
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }

    public static void main(String[] args) {
        //代理人和被代理人的关系是运行时候动态确定的，也就是在调用的时候才被确定
        IFindWork proxy= (IFindWork) ProxyFactory.getDynProxy(new Bob());
        //通过动态代理模式调用它的方法，都会调用一次invoke
        proxy.sendResume("BOB的简历");

        proxy.inviteInterview();
    }
}
