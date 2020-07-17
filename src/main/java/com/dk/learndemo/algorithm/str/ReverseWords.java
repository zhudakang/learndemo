package com.dk.learndemo.algorithm.str;

/**
 * @author :zhudakang
 * @description : ReverseWords
 * @create : 2020/07/17
 */
public class ReverseWords {

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
     * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     */
    public String reverseWords(String s) {
        //双指针做法
        s = s.trim(); // 删除首尾空格
        //从末尾开始，直到遇到空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            //substring 前包括 后不包括

            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //j和i相等
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        String a = "0123456789";
        System.out.println(a.substring(0,4));

    }
}
