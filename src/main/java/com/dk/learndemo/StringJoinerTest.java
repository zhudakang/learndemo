package com.dk.learndemo;

import java.util.StringJoiner;

/**
 * @Description : StringJoinerTest
 *                做字符串拼接，比较方便~
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class StringJoinerTest {

    public static void main(String[] args) {
        String ossUrl1 = "11";
        String ossUrl2 = "22";
        String ossUrl3 = "33";
        StringJoiner ossUrl = new StringJoiner(";");
        ossUrl.add(ossUrl1).add(ossUrl2).add(ossUrl3);
        String a = ossUrl.toString();
        System.out.println(ossUrl);
    }
}
