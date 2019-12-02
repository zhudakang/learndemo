package com.dk.learndemo.designpattern.single;

/**
 * @Description : HungrySingleton 饿汉式
 *                非常饥饿，启动项目就要创建(在类加载的时候)
 *                这个时候很可能会问到类加载的机制
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    /**
     * 在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变
     *  所以是线程安全的，可以直接用于多线程而不会出现问题
     *  但是在配置文件中动态去加载进去的常量会晚于类加载
     *  导致有些从yml文件中读的东西没有值。
     *
     *
     *   因为虚拟机保证只会装载一次，在装载类的时候是不会发生并发的。
     *   缺点：不一定会用到就已经加载到内存了
     * */
    public static HungrySingleton getInstance() {
        return instance;
    }
}
