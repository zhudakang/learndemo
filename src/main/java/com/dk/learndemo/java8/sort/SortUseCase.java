package com.dk.learndemo.java8.sort;

import org.assertj.core.util.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

/**
 * @Author : zhudakang
 * @Description : SortUseCase
 * @Date : 2019/6/14
 */
public class SortUseCase {

    public static List<User> users = Lists.newArrayList(
            new User("jack",17,10),
            new User("jack",18,10),
            new User("jack",18,9),
            new User("jack",19,11),
            new User("apple",25,15),
            new User("tommy",23,8),
            new User("jessica",15,13)
    );

    /**
     * before java 8
     * */
    public static void traditionCompareByAge(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void traditionCompareByAgeInJava8(){
        users.sort((o1, o2) -> o1.getAge() - o2.getAge());
        users.forEach(user -> System.out.println(user));
    }

    //use method reference
    public static void traditionCompareByAge2(){
        users.sort(comparingInt(User::getAge).reversed());
        users.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        traditionCompareByAge();
//        traditionCompareByAgeInJava8();
//        traditionCompareByAge2();
//        traditionCombinationCompare();
//        traditionCombinationCompareInJava8();
        traditionCombinationCompare2();
    }

    //多条件组合 按照姓名，年龄与积分的顺序依次排序
    public static void traditionCombinationCompare(){
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getName().equals(o2.getName())) {
                    if (o1.getAge().equals(o2.getAge())) {
                        return o1.getCredits() - o2.getCredits();
                    } else {
                        return o1.getAge() - o2.getAge();
                    }
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
        users.forEach(System.out::println);
    }

    //use thenCompring
    public static void traditionCombinationCompareInJava8(){
        users.sort(comparing(User::getName)
                .thenComparing(User::getAge)
                .thenComparing(User::getCredits));
        users.forEach(System.out::println);
    }

    //姓名顺序->年龄倒序->积分顺序
    //comparing(User::getAge).reversed()
    public static void traditionCombinationCompare2(){
        users.sort(comparing(User::getName)
                .thenComparing(User::getAge, (o1, o2) -> o2 - o1)
                .thenComparing(User::getCredits));
        users.forEach(System.out::println);
    }
}
