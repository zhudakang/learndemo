package com.dk.learndemo.algorithm.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : Subsets
 * @create : 2020/08/18
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        //输出
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList());

        for (int num : nums) {

            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1,0};
        subsets(nums);
    }
}
