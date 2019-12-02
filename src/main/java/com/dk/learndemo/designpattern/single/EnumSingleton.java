package com.dk.learndemo.designpattern.single;

/**
 * @Description : EnumSingleton
 *                解决多线程同步问题，而且能防止反序列化重新创建新的对象
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public enum EnumSingleton {
    INSTANCE;

    public void getInstance() {
    }
}
