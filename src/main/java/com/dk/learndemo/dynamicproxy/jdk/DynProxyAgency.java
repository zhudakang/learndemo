package com.dk.learndemo.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : zhudakang
 * @Description : DynProxyAgency 这是一个动态代理的中介！
 *                这是使用JDK标准的动态代理的实现！
 *                但是JDK的动态代理只能对实现了这个InvocationHandler接口的进行代理。
 * @Date : 2019/8/1
 */
public class DynProxyAgency implements InvocationHandler {

    //被代理的对象
    private Object target;

    public DynProxyAgency(Object objectj) {
        this.target = objectj;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        System.out.println("调用invoke,使用的方法："+ method.getName());
        Object result=method.invoke(target,args);
        return result;
    }

}
