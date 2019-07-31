package com.dk.learndemo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @Author : zhudakang
 * @Description : Person
 * @Date : 2019/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int age;
    private String name;
    private Optional<God> god;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
