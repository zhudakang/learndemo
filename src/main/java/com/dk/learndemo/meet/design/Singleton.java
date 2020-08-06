package com.dk.learndemo.meet.design;

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
}
