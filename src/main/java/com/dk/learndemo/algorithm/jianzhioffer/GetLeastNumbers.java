package com.dk.learndemo.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :zhudakang
 * @description : GetLeastNumbers
 * @create : 2020/06/30
 */
public class GetLeastNumbers {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * 示例 1：
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     * */
    public int[] getLeastNumbers(int[] arr, int k) {

        //TOPK问题，应该使用快拍最快解决TopK
        //想法是先排序，然后找K个

        quicksort(arr, 0, arr.length -1);

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        //以左边left为哨兵位置
        int pivot = n[left];

        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
