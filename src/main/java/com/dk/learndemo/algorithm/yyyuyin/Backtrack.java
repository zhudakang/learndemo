package com.dk.learndemo.algorithm.yyyuyin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/7/5
 */
public class Backtrack {

    /**
     * 全排列的解法！
     * 这个是题干
     * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        //res是结果 当first == n-1的时候，那么也就结束了一次递归
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            //因为动态在output上面改
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组 交换first 与当前的i
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


}
