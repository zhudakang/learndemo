package com.dk.learndemo.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhudakang
 * @description : TwoSum
 * @create : 2020/06/04
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length ; i++){

            for(int j = i+1; j < nums.length; j++ ){
                if(nums[i] + nums[j] == target ){
                    int[]  result =  {i,j};
                    return result;
                }
            }
        }
        throw new RuntimeException("no such nums");
    }

    /**
     * 凡是如果两层循环的，一定要想着借助hashMap来实现
     * 因为这个数字不会跟自己搞。
     * 所以这样写是没有问题的
     * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No two sum solution");
    }
}
