package com.dk.learndemo.algorithm.arr;

import java.util.HashMap;

/**
 * @author :zhudakang
 * @description : MaxWidth
 * @create : 2020/07/18
 */
public class MaxWidth {

    /**
     * 最大宽度正序对
     * 给定数组 如果A[I] <A [J]
     * 那么i j 就是一个正序对
     * 求最大ij距离
     */
    public static int maxWidth(int[] A) {
        // write code here
        int max = 0;
        if (A == null || A.length == 0 || A.length == 1) {
            return max;
        }
        for (int i = 0; i < A.length; i++) {
            if (A.length - i <= max) {
                break;
            }
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] - A[i] > 0 && j - i > max) {
                    max = j - i;
                }
            }
        }
        return max;
    }

    public static int maxWidth2(int[] A) {
        // write code here
        int max = 0;
        if (A == null || A.length == 0 || A.length == 1) {
            return max;
        }
        for (int i = 1; i < A.length; i++) {
            //从前面找就好了
            int j = 0;
            while(j != i && i-j > max){
                if (A[i]  >= A[j]) {
                    max = i - j;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = new int[]{6, 0, 8, 2, 1, 5};
        System.out.println(maxWidth2(A));
    }
}
