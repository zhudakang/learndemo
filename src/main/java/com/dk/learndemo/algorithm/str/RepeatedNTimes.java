package com.dk.learndemo.algorithm.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :zhudakang
 * @description : RepeatedNTimes
 * @create : 2020/06/15
 */
public class RepeatedNTimes {

    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,3]
     * 输出：3
     * <p>
     * 输入：[2,1,2,5,3,2]
     * 输出：2
     * <p>
     * 输入：[5,1,5,2,5,3,5,4]
     * 输出：5
     * 提示：
     * 4 <= A.length <= 10000
     * 0 <= A[i] < 10000
     * A.length 为偶数
     * DK的解法
     */
    public int repeatedNTimes(int[] A) {

        //数学问题啊，只有一个元素会超过2的
        int x = A.length / 2;
        Set hashSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            if (!hashSet.add(A[i])) {
                return A[i];
            }
        }
        return -1;
    }

    public int repeatedNTimes2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] == arr[i + 1] || arr[i] == arr[i + 2]) {
                return arr[i];
            }
        }

        // 上面循环没找到，那必然是最后一个数，如[1,2,3,1]
        return arr[len - 1];
    }

    /**
     * 这种解法主要是，要在意的点是getOrDefault(x,0)有的话就给值，没有用默认
     */
    public int repeatedNTimes3(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k : count.keySet())
            if (count.get(k) > 1)
                return k;

        throw null;
    }



}
