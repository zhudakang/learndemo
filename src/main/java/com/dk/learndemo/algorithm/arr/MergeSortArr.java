package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : MergeSortArr
 * @create : 2020/07/01
 */
public class MergeSortArr {

    /**
     * 合并排序
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * <p>
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 1.直接合并然后排序（没有利用排序 还不如不写）
     * 2.双指针
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        //用temp保存A的数组，然后在A上面做修改
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = A[i];
        }

        int aPoint = 0;
        int bPoint = 0;
        int i = 0;
        while (aPoint != m && bPoint != n) {

            if (temp[aPoint] <= B[bPoint]) {
                A[i] = temp[aPoint];
                aPoint++;
            } else {
                A[i] = B[bPoint];
                bPoint++;
            }
            i++;
        }

        if (aPoint == m) {
            for (; bPoint < n; ++bPoint, ++i) {
                A[i] = B[bPoint];
            }
        } else {
            for (; aPoint < m; ++aPoint, ++i) {
                A[i] = temp[aPoint];
            }
        }
    }

    public static void main(String[] args) {

        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
}
