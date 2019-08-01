package com.dk.learndemo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

/**
 * @Author : zhudakang
 * @Description : ConsumerMethod
 * java.util.function 中有一些函数式接口比较有意思
 * 比如 Function, Supplier, Consumer, Predicate
 *
 * default Consumer<T> andThen(Consumer<? super T> after)
 *  对给定的参数T执行定义的操作执行再继续执行after定义的操作
 * @Date : 2019/6/14
 */
public class ConsumerMethod {

    private static List<Person> list = new ArrayList<>();
    private static List<Person> consumerList = new ArrayList<>();


    public static void main(String[] args) {
        Consumer<Person> consumer  = x -> {
            if (x.getName().equals("lisi")){
                consumerList.add(x);
            }
        };
        consumer = consumer.andThen(
                x -> consumerList.removeIf(y -> y.getAge() < 23)
        );
        Stream.of(
                new Person(21,"zhangsan"),
                new Person(22,"lisi"),
                new Person(23,"wangwu"),
                new Person(24,"wangwu"),
                new Person(23,"lisi"),
                new Person(26,"lisi"),
                new Person(26,"zhangsan")
        ).forEach(consumer);

        System.out.println("==============");
        consumerList.forEach(System.out::println);

    }


}
