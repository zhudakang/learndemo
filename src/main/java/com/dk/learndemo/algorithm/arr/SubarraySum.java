package com.dk.learndemo.algorithm.arr;

import java.util.HashMap;

/**
 * @author :zhudakang
 * @description : SubarraySum
 * @create : 2020/07/10
 */
public class SubarraySum {

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 其实有点像是所有连续子数组
     * 属于数学推导：
     * pre[i] = 0 -i 的和
     * [j..i]这个子数组和为 k
     * pre[i]−pre[j−1]=k
     * 移项
       pre[j−1] = pre[i]−k

     虑以 i结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和 为 pre[i]−k 的 pre[j] 即可

     卧槽，因为pre是不断累加的。
     pre[i]=pre[i−1]+nums[i] 加就完事了。
     那么到pre[i]这里的时候，他需要找到一个pre[j-1]
     那么把之前的pre全放进去就好了
     */
    public static int subarraySum2(int[] nums, int k) {

        //输出子数组个数
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        //这个Map的意义是什么？
        map.put(0, 1);
        //循环n次
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            //这个map存的是出现的次数。
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
         subarraySum2(new int[]{1,-1,0,1,2,0,1,-1}, 0);
    }

}
