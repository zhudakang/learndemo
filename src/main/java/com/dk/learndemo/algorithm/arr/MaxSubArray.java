package com.dk.learndemo.algorithm.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhudakang
 * @description : MaxSubArray
 * @create : 2020/07/03
 */
public class MaxSubArray {
    /**
     * 求一个数组中，最大子数组
     * 连续元素
     * */
    public static Integer[] maxSubarray(Integer[] list) {
        int maxSoFar = 0;
        int maxToHere = 0;
        //记一下距离
        int l = 0;
        int r = 0;
        int temp = 0;
        //做一次循环
        for (int a = 0; a < list.length; a++) {
            if (maxToHere < 0) {
                maxToHere = list[a];
                temp = a;
            } else {
                maxToHere += list[a];
            }

            //说明加上有增益效果
            if (maxToHere >= maxSoFar) {
                maxSoFar = maxToHere;
                l = temp;
                r = a;
            }
        }
        System.out.println((l) + " " + (r) + " max: " + maxSoFar);
        //做数组拷贝
        return Arrays.copyOfRange(list, l, r);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,-5,-6,1,2,6,7};
        System.out.println(maxSubarray(a));
    }
}
