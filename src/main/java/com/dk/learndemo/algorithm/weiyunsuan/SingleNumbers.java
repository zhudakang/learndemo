package com.dk.learndemo.algorithm.weiyunsuan;

import java.util.Arrays;

/**
 * @author :zhudakang
 * @description : SingleNumbers
 * @create : 2020/07/01
 */
public class SingleNumbers {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     * 输入：nums = [4,1,4,6]
     * 输出：[1,6] 或 [6,1]
     * <p>
     * 主要是对两个不同数字的分组
     * <p>
     * 奇偶运算：& 1 操作， 当我们对奇偶分组时，容易地想到 & 1，即用于判断最后一位二进制是否为 1。来辨别奇偶。
     */
    public int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for (int num : nums) {
            k ^= num;
        }
        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask
        //那么当k & mask != 0的时候，那么说明找到了这个不一样的一位了
        while ((k & mask) == 0) {
            //mask = mask << 1;
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        //这部分操作是什么呢？相当于循环一次数组
        //与运算只有都为1在某一位，才有值，否则都为0，那么这样一定会把这两个数分开。最后能求出来a和b
        for (int num : nums) {
            //mask与数字做异或
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
