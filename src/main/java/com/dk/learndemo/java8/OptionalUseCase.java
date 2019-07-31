package com.dk.learndemo.java8;

import java.util.Optional;

/**
 * @Author : zhudakang
 * @Description : OptionalUseCase
 * @Date : 2019/6/14
 */
public class OptionalUseCase {

    //方法of()用于创建非空对象，该方法要求传入的参数不能为空，否则抛NullPointException，
    public static void test1() {
        Optional<Person> optional = Optional.of(null);
        Person person = optional.get();
        System.out.println(person);
    }

    //由于传入的参数可能为null，则可以用Optional的ofNullable()方法创建对象，如果参数为null，则创建一个空对象。
    public static void test2() {
        Optional<Person> optional = Optional.ofNullable(null);
        Person person = optional.orElseGet(()->new Person() );
        System.out.println(person);
    }


    public static void test3(){
        Optional<God> op = Optional.ofNullable(new God(""));
        Optional<Person> man = Optional.ofNullable(new Person(20,"小妹", op));
        System.out.println(man);
        System.out.println(man.orElse(new Person())//如果man是null则新创建一个对象
                .getGod().orElse(new God("hh")).getGodnessName());
    }

    public static void main(String[] args) {
//        test2();
        test3();
    }

}
