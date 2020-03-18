package com.dk.learndemo.aop.jdk;

/**
 * @author :zhudakang
 * @description : UserService
 *                 JDK动态代理通过反射来接收被代理的类，并且要求被代理的类必须实现一个接口，核心是InvocationHandler接口和Proxy类
 * @create : 2020/03/18
 */
public interface UserService {
    void addUser(String userName,String password);
    String delUser(String userName);
}
