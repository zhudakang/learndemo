package com.dk.learndemo.algorithm.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhudakang
 * @description : Fib
 * @create : 2020/07/01
 */
public class Fib {


    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     */
    public int fib(int n) {
        //写递归
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            //虽然递归很完美，但是很慢
            return fib(n-1) + fib(n-2);
        }
    }

    Map fibMap = new HashMap();

    /**
     * 优化递归法
     * */
    public int fib2(int n) {
        //写递归
        if (n == 0) {
            fibMap.put(0, 0);
            return 0;
        } else if (n == 1) {
            fibMap.put(1, 1);
            return 1;
        } else {
            int a,b;
            if(fibMap.get(n-1) == null){
                fibMap.put(n-1, fib(n-1));
            }
            if(fibMap.get(n-2) == null){
                fibMap.put(n-2, fib(n-2));
            }

            //虽然递归很完美，但是很慢

            return ((int)fibMap.get(n-1) + (int)fibMap.get(n-2))% 1000000007;
        }
    }


    /**
     * 遍历法解时间复杂度是o
     * 但是这种没有取模
     * */
    public static int f2(int n){
        int f0 = 0;
        if (n == 0) {
            return f0;
        }
        int f1 = 1;
        if (n == 1) {
            return f1;
        }
        int f2 = 0;
        for (int i = 2; i <= n; i++) {
            //对f2 重新赋值
            f2 = f0 + f1;
            //往后移动
            f0 = f1;
            //往后面移动
            f1 = f2;
        }
        return f2;
    }

}
