package com.dk.learndemo.meet.design;

import java.io.ObjectStreamException;
import java.lang.reflect.Constructor;

/**
 * @author :zhudakang
 * @description : Singleton
 * @create : 2020/08/06
 */
public class Singleton {
    private static volatile Singleton instance = null;
    private Singleton(){};
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    private Object readResolve() throws ObjectStreamException {

        // instead of the object we're on,
        // return the class variable INSTANCE

        return instance;
    }


    /**
     * 就算我们保证了线程安全，这种写法还是无法保证存在唯一一个对象实例。
     * 因为别人还是可以通过反射的方式来创建一个新的对象。
     * */
    public static void main(String[] args) throws Exception{
        //获得构造器
        Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
        //把构造器设置为可访问
        c.setAccessible(true);
        //创建两个实例对象
        Singleton s1 = c.newInstance();
        Singleton s2 = c.newInstance();
        //比较下两个实例是否相等
        System.out.println(s1 == s2);
    }
}
