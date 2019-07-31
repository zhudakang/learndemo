package com.dk.learndemo.java8;

import java.util.function.Function;

/**
 * @Author : zhudakang
 * @Description : FunctioUseCase
 * @Date : 2019/6/14
 */
public class FunctioUseCase {

    public static void test1() {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        System.out.println("F1:" + B.apply(A.apply(5)));
        System.out.println("F2:" + A.apply(B.apply(5)));
    }

    public static void test2() {
        Function<Integer, Integer> A = i -> i + 1;
        Function<Integer, Integer> B = i -> i * i;
        System.out.println("F1:" + B.apply(A.apply(5)));
        System.out.println("F1:" + B.compose(A).apply(5));  //compose means  B.apply(A.apply(5))
        System.out.println("F2:" + A.apply(B.apply(5)));
        System.out.println("F2:" + B.andThen(A).apply(5));  //and then means A.apply(B.apply(5))
        //andThen跟compose正相反，先执行当前的逻辑，再执行传入的逻辑。
    }

    public static void main(String[] args) {
        test2();
    }

}
