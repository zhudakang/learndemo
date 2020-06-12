package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : MergeArr
 * System.arraycopy
 * @create : 2020/06/12
 */
public class MergeArr {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //需要暂存一下前m个元素
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        //双指针法可以解决排序数组链表问题
        int p1 = 0;
        int p2 = 0;

        // nums1盛放最后的元素
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // if there are still elements to add
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
