package com.dk.learndemo.java8;

import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @Author : zhudakang
 * @Description : NullCheck
 *
 * @Date : 2019/6/14
 */
public class NullCheck {

    private String name;

    private String type;

    public NullCheck(@NonNull String name, String type) {
        this.name = name;
        this.type = Objects.requireNonNull(type);
    }

    @Override
    public String toString(){
        return "NullCheck{ name: " + name + ", type: " + type + "}";
    }

    public static void main(String[] args) {

        System.out.println();
        NullCheck nullCheck = new NullCheck(null, null);
        System.out.println(nullCheck);
    }
}
