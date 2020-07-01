package com.dk.learndemo.algorithm.sort;

import java.util.*;

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

    /**
     * 堆排序！
     * 比较直观的想法是使用堆数据结构来辅助得到最小的 k 个数。
     * 堆的性质是每次可以找出最大或最小的元素。我们可以使用一个大小为 k 的最大堆（大顶堆），将数组中的元素依次入堆，当堆的大小超过 k 时，便将多出的元素从堆顶弹出。
     * 我们以数组 [5, 4, 1, 3, 6, 2, 9][5,4,1,3,6,2,9]， k=3k=3 为例展示元素入堆的过程，如下面动图所示：
     *
     *
     *
     * 这样，由于每次从堆顶弹出的数都是堆中最大的，最小的 k 个元素一定会留在堆里。这样，把数组中的元素全部入堆之后，堆中剩下的 k 个元素就是最大的 k 个数了。
     * 注意在动画中，我们并没有画出堆的内部结构，因为这部分内容并不重要。我们只需要知道堆每次会弹出最大的元素即可。
     * 在写代码的时候，我们使用的也是库函数中的优先队列数据结构，如 Java 中的 PriorityQueue。
     * 在面试中，我们不需要实现堆的内部结构，把数据结构使用好，会分析其复杂度即可。
     * 这里的代码可以做一些优化，如果当前数字不小于堆顶元素，数字可以直接丢掉，不入堆。
     *
     *
     * 由于使用了一个大小为 k 的堆，空间复杂度为 O(k)O(k)；
     * 入堆和出堆操作的时间复杂度均为 O(\log k)O(logk)，每个元素都需要进行一次入堆操作，故算法的时间复杂度为 O(n \log k)O(nlogk)。
     * */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }

        // 使用一个最大堆（大顶堆）堆是一颗顺序存储的完全二叉树
        //大顶堆根节点是最大的数字   小丁对是根节点值最小
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        //设置初始容量为k
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                //e小于栈顶也可以，heap.offer可以压入元素
                heap.offer(e);
            }
            if (heap.size() > k) {
                //上面加入进去之后，heap在这边删除，堆是会扩容的
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }
}
