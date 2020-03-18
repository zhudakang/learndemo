package com.dk.learndemo.aop.jdk;

/**
 * @author :zhudakang
 * @description : UserServiceImpl
 * @create : 2020/03/18
 */
public class UserServiceImpl implements UserService {

    //重写新增用户方法
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数为 userName: "+userName+" password: "+password);
    }
    //重写删除用户方法
    @Override
    public String delUser(String userName) {
        System.out.println("调用了删除的方法！");
        System.out.println("传入参数为 userName: "+userName);
        return "删除成功";
    }
}
