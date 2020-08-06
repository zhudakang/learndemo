package com.dk.learndemo.meet.design;

/**
 * @author :zhudakang
 * @description : Singleton3
 *                 单例工厂
 * @create : 2020/08/06
 */
public class Singleton3 {

    /**
     * 外部类无法访问静态内部类，因此只有当外部类调用Singleton.getInstance()方法的时候，才能得到instance实例。
     * 并且，instance实例对象初始化的时机并不是在Singleton被加载的时候，
     * 而是当getInstance()方法被调用的时候，静态内部类才会被加载，这时instance对象才会被初始化。并且也是线程安全的。
     * 所以，与饿汉式相比，通过静态内部类的方式，可以保证instance实例对象不会被白白浪费。
     * 但是，它仍然存在反射问题。
     * */

    //静态内部类
    private static class LazyHolder{
        private static Singleton3 instance = new Singleton3();
    }
    //私有构造器
    private Singleton3(){};
    public static Singleton3 getInstance() {
        return LazyHolder.instance;
    }
}
