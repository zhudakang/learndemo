package com.dk.learndemo.algorithm.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhudakang
 * @description : LengthOfLongestSubstring
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @create : 2020/06/04
 */
public class LengthOfLongestSubstring {

    /**
     * 输出长度
     */
    public static int lengthOfLongestSubstring(String s) {
        //dk的想法，使用Set来放元素
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        if(s.length() == 0){
            return 0;
        }
        int maxLength = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (!set.add(String.valueOf(chars[j]))) {
                    maxLength = set.size() > maxLength ? set.size() : maxLength;
                    set.clear();
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     * 使用滑动窗口解题
     * 也借助了map
     * twoSum 也借助了map
     *
     * */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
                //比如 abcabc 到了 第四个a的时候，会发现这时候进来，那么比较一下第1个a 位置加一 与0 的大小关系，取最大的。那么left就是1了
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }        //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
            map.put(s.charAt(i), i);      //再更新map中a映射的下标
            max = Math.max(max, i - left + 1);     //比较两个参数的大小
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
