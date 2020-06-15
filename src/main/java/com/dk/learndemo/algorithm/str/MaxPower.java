package com.dk.learndemo.algorithm.str;

/**
 * @author :zhudakang
 * @description : MaxPower
 * @create : 2020/06/15
 */
public class MaxPower {

    public int maxPower(String s) {
        if (s.length() < 2) return s.length();

        char[] charArr = s.toCharArray();
        int count = 1;
        int max = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (charArr[i] == charArr[i - 1]) {
                count++;
            } else {
                max = max >= count ? max : count;
                count = 1;
            }
        }
        //因为如果是eeeee这种，最后就需要再比较一下
        return Math.max(max, count);
    }
}
