package com.dk.learndemo.algorithm.arr;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhudakang
 * @description : RemoveDuplicates
 * @create : 2020/06/10
 */
public class RemoveDuplicates {

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     */


    public int removeDuplicates(int[] nums) {

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果他们俩不等的话，那么就让slow指针后移
            //但是原因是跳过了很多个之后，这两个位置的元素就不太一致了，所以需要把快指针的元素弄到前面去
            if(nums[i] != nums[slow]){
                slow++;
                nums[slow] = nums[i];
            }
            //如果相等就跳过
        }
        return slow;
    }
}
