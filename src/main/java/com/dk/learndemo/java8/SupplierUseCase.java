package com.dk.learndemo.java8;

import java.util.function.Supplier;

/**
 * @Author : zhudakang
 * @Description : SupplierUseCase
 * @Date : 2019/6/13
 */
public class SupplierUseCase {

    private int age;

    SupplierUseCase(){
        System.out.println(age);
    }

    public static void main(String[] args) {

        //创建Supplier容器，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<SupplierUseCase> sup= SupplierUseCase::new;
        System.out.println("--------");
        //调用get()方法，此时会调用对象的构造方法，即获得到真正对象
        sup.get();
        //每次get都会调用构造方法，即获取的对象不同
        sup.get();


        Supplier<String> sup2 = () -> "HelloWorld!";
        System.out.println(sup2.get());
    }
}
