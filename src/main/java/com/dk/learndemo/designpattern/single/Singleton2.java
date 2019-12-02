package com.dk.learndemo.designpattern.single;

/**
 * @Description : Singleton2 懒汉式 内部静态类
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class Singleton2 {

    private Singleton2() {
    }

    //内部类的初始化需要依赖主类，需要先等主类实例化之后，内部类才能开始实例化
    private static class LazyHolder {
        //这里加final是为了防止内部将这个属性覆盖掉
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    //这里加final是为了防止子类重写父类
    public static final Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
