package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : SearchTarget
 * @create : 2020/07/15
 */
public class SearchTarget {

    public static int search(int[] nums, int target) {
        //是否可以使用二分查找？
        //找到这个数然后前后指针走
        int result = 0;
        int low = 0;
        int high = nums.length -1;
        int pos = (low + high) / 2;
        while (low <= high) {
            if (nums[pos] == target) {
                result++;
                break;
            }
            if (nums[pos] > target) {
                high = pos - 1;

            } else {
                low = pos + 1;
            }
            pos = (low + high) / 2;
        }
        //对pos做处理
        int l = pos - 1;
        while (l >= 0 && nums[l] == target) {
            result++;
            l--;
        }
        int r = pos + 1;
        while (r < nums.length && nums[r] == target) {

            result++;
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        search(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
