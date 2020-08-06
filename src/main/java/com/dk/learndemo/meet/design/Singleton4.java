package com.dk.learndemo.meet.design;

import java.lang.reflect.Constructor;

/**
 * @author :zhudakang
 * @description : Singleton4
 * @create : 2020/08/06
 */
public enum  Singleton4 {

    instance;

    public Singleton4 getInstance(){
        return instance;
    }

    /**
     * 这种枚举的方式可以说的用的最多的一种方式了，
     * 唯一的缺点就是对象一开始就被创建，可能出现白白浪费没有用到对象的情况。
     * 通过枚举的方式，不仅代码简单，线程安全，而且JVM还能阻止反射获取枚举类的私有构造器。
     * */
    public static void main(String[] args) throws Exception{
        //获得构造器
        Constructor<Singleton4> c = Singleton4.class.getDeclaredConstructor();
        //把构造器设置为可访问
        c.setAccessible(true);
        //创建两个实例对象
        Singleton4 s1 = c.newInstance();
        Singleton4 s2 = c.newInstance();
        //比较下两个实例是否相等
        System.out.println(s1 == s2);
    }
}
