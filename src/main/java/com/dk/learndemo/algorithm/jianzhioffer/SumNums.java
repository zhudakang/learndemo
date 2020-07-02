package com.dk.learndemo.algorithm.jianzhioffer;

/**
 * @author :zhudakang
 * @description : SumNums
 * @create : 2020/07/01
 */
public class SumNums {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * 示例 1：
     * 输入: n = 3
     * 输出: 6
     */
    public int sumNums(int n) {
        //所以还能用啥？
        //只有加减法，赋值，位运算符以及逻辑运算符。
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
