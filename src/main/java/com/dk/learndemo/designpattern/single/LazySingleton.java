package com.dk.learndemo.designpattern.single;

/**
 * @Description : LazySingleton
 *                单例模式一般有两种，懒汉式和饿汉式
 *                懒汉式：是用时间换空间 (因为每次都要判断是否为空 并且使用同步关键字，会影响性能)
 *                如果一直没有人使用的话，那就不会创建实例，则节约内存空间。
 *
 *                饿汉式：空间换时间，当类装载的时候就会创建类实例，不管你用不用，先创建出来，然后每次调用的时候，就不需要再判断了，节省了运行时间。
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class LazySingleton {

    /**
     *
     * 懒汉式就是类加载的时候没有生成单例，只在第一次加载的时候判空，然后不为空则返回这个单例。
     * 但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点(因为每次访问都要用到synchronized的方法)
     * */
    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步

    /**
     * private 避免类在外部被实例化
     * */
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
