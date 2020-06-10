package com.dk.learndemo.algorithm.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :zhudakang
 * @description : FindMedianSortedArrays
 * @create : 2020/06/10
 */
public class FindMedianSortedArrays {

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * 什么是中位数？
     *
     * 负分实例
     * 注意运算符和括号
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(Double.valueOf(nums1[i]));
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(Double.valueOf(nums2[i]));
        }
        int length = list.size();
        if(length == 0){
            return 0.0;
        }
        Collections.sort(list);
        if (length % 2 == 0) {
            return (list.get(length / 2 -1) + list.get(length / 2)) / 2.0;
        } else {
            System.out.println((length + 1) / 2 - 1);
            return list.get((length + 1) / 2 - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(  findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
