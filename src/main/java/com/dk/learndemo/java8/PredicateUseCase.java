package com.dk.learndemo.java8;

import java.util.function.Predicate;

/**
 * @Author : zhudakang
 * @Description : PredicateUseCase
 * @Date : 2019/6/14
 */
public class PredicateUseCase {

    public static void main(String[] args) {
        Predicate<Integer> preCase = integer -> integer % 2 == 1;
        System.out.println(preCase.test(7));
        //控制台输出 5
    }

}
