package com.dk.learndemo.java8.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Repeatable;

/**
 * @Author : zhudakang
 * @Description : User
 * @Date : 2019/6/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Integer credits;
}
