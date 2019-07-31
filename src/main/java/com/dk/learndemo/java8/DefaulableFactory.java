package com.dk.learndemo.java8;

import java.util.function.Supplier;

/**
 * @Author : zhudakang
 * @Description : DefaulableFactory
 * @Date : 2019/6/13
 */
public class DefaulableFactory {

    /**
     *Supplier
     * */
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.myDefalutMethod());

        defaulable = DefaulableFactory.create(OverrideDefaultImpl::new);
        System.out.println(defaulable.myDefalutMethod());
    }
}
