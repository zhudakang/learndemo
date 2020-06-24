package com.dk.learndemo.algorithm.str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author :zhudakang
 * @description : MinWindow
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * @create : 2020/06/04
 */
public class MinWindow {



    /**
     * Character 与Char
     * Char并不是char的包装类
     * Char 是 com.alibaba.druid.sql.visitor.functions;
     * */
    public static Map<Character, Integer> ori = new HashMap<Character, Integer>();
    public static Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    /**
     * 我本来的思路是，两层循环，那么使用set看看是否都存在。
     * 记录一个最小的。
     *
     * 滑动窗口的思想
     * 都是借助map来进行处理
     *
     * 滑动窗口：一个l 和一个r
     *
     * 左右指针一样的东西，如果窗口不包含t，那么将r进行右移直到包含了t
     * 然后l进行右移 直到不包含，看看能不能收缩。
     *
     * 本问题要求我们返回字符串 ss 中包含字符串 tt 的全部字符的最小窗口。我们称包含 tt 的全部字母的窗口为「可行」窗口。
     *
     * 我们可以用滑动窗口的思想解决这个问题，在滑动窗口类型的问题中都会有两个指针。一个用于「延伸」现有窗口的 rr 指针，
     * 和一个用于「收缩」窗口的 ll 指针。在任意时刻，只有一个指针运动，而另一个保持静止。我们在 ss 上滑动窗口，通过移动 rr 指针不断扩张窗口。
     * 当窗口包含 tt 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
     * 官方解题：
     * */
    public static String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            //这边为什么要从1开始？因为要记录出现的次数
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        //sLen 是s的长度
        int sLen = s.length();
        //一次循环就够了
        while (r < sLen) {
            //从0开始 这个写法
            ++r;
            //这个判断是 ++r之后的在判断的
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 这道题需要ADOBECODEBANC  输出 ABCC
     * 包含所有字符的意思也就是出现几次 得包含几次
     * */
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABCC"));
    }

}
