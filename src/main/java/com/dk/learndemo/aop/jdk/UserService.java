package com.dk.learndemo.aop.jdk;

/**
 * @author :zhudakang
 * @description : UserService
 * @create : 2020/03/18
 */
public interface UserService {
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    String delUser(String userName);
}
