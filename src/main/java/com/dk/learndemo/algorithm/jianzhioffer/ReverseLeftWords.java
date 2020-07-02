package com.dk.learndemo.algorithm.jianzhioffer;

/**
 * @author :zhudakang
 * @description : ReverseLeftWords
 * @create : 2020/06/30
 */
public class ReverseLeftWords {

    /**
     *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * 粗暴解法：
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (int i = n; i < charArr.length; i++) {
            sb.append(charArr[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }

    public String reverse2(String s, int n){
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    public String reverseLeftWords3(String s, int n){
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            //利用区域操作 i%长度从N开始，知道n+ s.length
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "12345678";
        System.out.println(a.substring(0,2));
        //这个属于前包后不包括
        System.out.println(a.substring(2,8));
    }

}
