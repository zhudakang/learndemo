package com.dk.learndemo.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : zhudakang
 * @Description : MyAnnotationContainer
 * @Date : 2019/6/14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationContainer {
    MyAnnotation[] value();
}
