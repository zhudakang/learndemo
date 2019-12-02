package com.dk.learndemo.designpattern.single;

/**
 * @Description : Singleton 比较完美的双重检查加锁
 * 不会一直访问同步方法 也保证线程安全
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
            //同步块，线程安全地创建实例
            synchronized (Singleton.class) {
                //再次检查实例是否存在，如果不存在才真正地创建实例
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
