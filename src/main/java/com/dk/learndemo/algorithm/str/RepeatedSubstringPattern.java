package com.dk.learndemo.algorithm.str;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/7/5
 */
public class RepeatedSubstringPattern {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，
     * 并且长度不超过10000。
     */
    public boolean repeatedSubstringPattern(String s) {

        //头皮发麻 滑动窗口解法
        String str = s +s ;
        return str.substring(1, str.length() -1 ).contains(s);
    }
}
