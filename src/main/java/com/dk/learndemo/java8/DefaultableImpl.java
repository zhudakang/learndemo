package com.dk.learndemo.java8;

/**
 * @Author : zhudakang
 * @Description : DefaultableImpl
 * @Date : 2019/6/13
 */
public class DefaultableImpl implements Defaulable {

    public static void main(String[] args) {
        Defaulable defaulable = new DefaultableImpl();
        System.out.println(defaulable.myDefalutMethod());
    }
}

