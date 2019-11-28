package com.dk.learndemo.designpattern.adapter.clazzadapter;

/**
 * @Description : AdapterTest
 * @Date : 2019/11/28
 * @Author : zhudakang
 */
public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        /**
         * 利用类的继承和实现接口
         * 使得创建的目标对象可以去兼容Adaptee的方法
         * 并且把adaptee的子类，让它可以去转换成目标对象
         * 实现了将适配者转换成了目标对象。
         * 然后调用目标对象的方法~
         * */
        Target target = new Adapter();
        target.request();
    }
}
