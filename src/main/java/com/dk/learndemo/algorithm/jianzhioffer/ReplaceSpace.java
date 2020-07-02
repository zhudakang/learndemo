package com.dk.learndemo.algorithm.jianzhioffer;

/**
 * @author :zhudakang
 * @description : ReplaceSpace
 * @create : 2020/07/01
 */
public class ReplaceSpace {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {

        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace2(String s) {

        StringBuilder sb = new StringBuilder();
        char[] inputArr = s.toCharArray();
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(inputArr[i]);
            }
        }
        return sb.toString();
    }


}
