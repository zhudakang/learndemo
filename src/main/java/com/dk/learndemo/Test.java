package com.dk.learndemo;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author :zhudakang
 * @description : Test
 * @create : 2020/04/07
 */
public class Test {
    public static  final  InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws Exception {
        inheritableThreadLocal.set("inheritableThreadLocal hello");
        threadLocal.set("threadLocal world");
        new Thread(()->{
            System.out.println(String.format("子线程可继承值：%s", inheritableThreadLocal.get()));
            System.out.println(String.format("子线程值：%s", threadLocal.get()));

            new Thread(()->{
                System.out.println(String.format("孙线程可继承值：%s", inheritableThreadLocal.get()));
                System.out.println(String.format("孙线程值：%s", threadLocal.get()));


            }).start();

        }).start();
    }
}
