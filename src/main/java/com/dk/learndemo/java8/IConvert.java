package com.dk.learndemo.java8;

/**
 * @Author : zhudakang
 * @Description : IConvert
 * @Date : 2019/6/13
 */
@FunctionalInterface
interface IConvert<F, T> {
    T convert(F item);
}
