package com.dk.learndemo.meet.design;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author :zhudakang
 * @description : EnumSingleton
 * @create : 2020/08/06
 */
public enum EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 反射在通过newInstance创建对象时，会检查该类是否ENUM修饰，如果是则抛出异常，反射失败。
     * */
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
        System.out.println("正常情况下，实例化两个实例是否相同：" + (singleton1 == singleton2));
        Constructor<EnumSingleton> constructor = null;
//        constructor = EnumSingleton.class.getDeclaredConstructor();
        constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);//其父类的构造器
        constructor.setAccessible(true);
        EnumSingleton singleton3 = null;
        //singleton3 = constructor.newInstance();
        singleton3 = constructor.newInstance("testInstance", 66);
        System.out.println(singleton1 + "\n" + singleton2 + "\n" + singleton3);
        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同：" + (singleton1 == singleton3));
    }
}
