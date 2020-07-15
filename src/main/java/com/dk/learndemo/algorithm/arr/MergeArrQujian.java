package com.dk.learndemo.algorithm.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :zhudakang
 * @description : MergeArrQujian
 * @create : 2020/07/15
 */
public class MergeArrQujian {

    /**
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 必须做的事情
     * */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        //从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            //left
            int left = intervals[i][0];
            //right
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            //intervals[i + 1][0] 左小于他的右
            //判断重叠
            //只有当下一个元素跟这个元素的right的有交叉，进入循环
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                //先加在比较
                i++;
                //比较哪个右大
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
