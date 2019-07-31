package com.dk.learndemo.java8;

import lombok.Data;

import java.util.Arrays;

/**
 * @Author : zhudakang
 * @Description : MyAnnotationTest
 * @Date : 2019/6/14
 */
@MyAnnotation("Hello")
@MyAnnotation("World")
@Data
//@MyAnnotationContainer({ @MyAnnotation("Hello"), @MyAnnotation("World") })
public class MyAnnotationTest {
    public static void main(String[] args) {
        Class<MyAnnotationTest> clazz = MyAnnotationTest.class;
        // 根据注解类型获取Main类上的所有注解
        MyAnnotation[] annotations = clazz.getAnnotationsByType(MyAnnotation.class);
        // 输出找到的所有注解
        Arrays.stream(annotations).forEach(System.out::println);

    }

}
