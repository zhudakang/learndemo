package com.dk.learndemo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : zhudakang
 * @Description : InterfaceStaticMethod
 * @Date : 2019/6/13
 */
public class InterfaceStaticMethod {

    public static void test(List<String> list) {
        //直接使用Comparator的静态方法
        list.sort(Comparator.comparing(String::length));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("11", "13", "2", "6");
        test(list);
        list.forEach(item -> System.out.println(item));
    }
}
