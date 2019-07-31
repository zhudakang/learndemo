package com.dk.learndemo.java8;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 使用范围在类、接口和枚举
@Retention(RetentionPolicy.RUNTIME) // 生命周期在运行时期，可以进行反射操作
@Repeatable(MyAnnotationContainer.class)
public @interface MyAnnotation {
    String value();
}
