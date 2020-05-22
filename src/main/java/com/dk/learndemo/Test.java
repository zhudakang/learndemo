package com.dk.learndemo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author :zhudakang
 * @description : Test
 * @create : 2020/04/07
 */
public class Test {

    private static List<List<Integer>> res = new ArrayList<>();


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        System.out.println(Arrays.toString(candidates));
        if (candidates == null) {
            return res;
        }
        dfs(target, 0, new Stack<Integer>(), candidates);
        return res;
    }

    //深度遍历
    private static void dfs(int target, int index, Stack<Integer> pre, int[] candidates) {
        System.out.println(target);
        System.out.println(Arrays.toString(new ArrayList[]{new ArrayList<>(pre)}));
        //等于零说明结果符合要求
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            System.out.println("^^^^^^^^^^");
            System.out.println(Arrays.toString(new ArrayList[]{new ArrayList<>(pre)}));
            System.out.println(Arrays.toString(new List[]{res}));
            System.out.println("^^^^^^^^^^");
            return;
        }

        //遍历，index为本分支上一节点的减数的下标
        for (int i = index; i < candidates.length; i++) {
            //如果减数大于目标值，则差为负数，不符合结果
            if (candidates[i] <= target) {
                pre.push(candidates[i]);
                System.out.println("!!!!!");
                System.out.println(i);
                System.out.println(Arrays.toString(candidates));
                System.out.println(target);
                System.out.println(Arrays.toString(new ArrayList[]{new ArrayList<>(pre)}));
                System.out.println("@@@@@");
                //目标值减去元素值
                dfs(target - candidates[i], i, pre, candidates);
                //每次回溯将最后一次加入的元素删除
                pre.pop();
            }
        }
    }
}
