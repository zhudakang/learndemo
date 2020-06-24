package com.dk.learndemo.algorithm.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhudakang
 * @description : ThreeSum
 * 可以直接对int数组做操作Arrays.sort(nums);
 * @create : 2020/06/12
 */
public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * 那么按照顺序递增的三元组就好了
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     **
     * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
     * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
     * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
     */
    /**
     * 主要是去重通过排序去重
     *
     **
     * 1. 特判，对于数组长度 nn，如果数组为 null 或者数组长度小于 33，返回 [][]。
     * 2. 对数组进行排序。
     * 3. 遍历排序后数组：
     *     若 nums[i]>0 ：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     *     对于重复元素：跳过，避免出现重复解
     *     令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
     *         当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R移到下一位置，寻找新的解
     *         若和大于 0，说明 nums[R] 太大，RR 左移
     *         若和小于 0，说明 nums[L] 太小，LL 右移
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            //先进行排序 如果排序之后的数字还大于0那么也就不用算了
            if (nums[i] > 0) return lists;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            //当前的数字
            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L + 1] == nums[L]) ++L;
                    while (L < R && nums[R - 1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if (tmp < 0) {
                    //需要增加
                    ++L;
                } else {
                    //需要降低
                    --R;
                }
            }
        }
        return lists;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 2; ++i) {
            //使用++i在循环中效率更高
            System.out.println(i);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
    }
}
