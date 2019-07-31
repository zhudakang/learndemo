package com.dk.learndemo.java8;

public interface Defaulable {
    //使用default关键字声明了一个默认方法

    default String myDefalutMethod() {
        return "Default implementation";
    }

}
