package com.dk.learndemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * @Description : PasswordUtils
 * @Date : 2019/11/5
 * @Author : pmdream
 */
public class PasswordUtils {


    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean matchesPassword(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(encodePassword("12345678"));
        }
        System.out.println("加密密码的位数" + "$2a$10$DD76Xn7zBe55rV1LW45Kou2sLPboY0FJMdHLCn8tl0BDdGrlhgcLO".length());
        System.out.println(matchesPassword("12345678", "$2a$10$7CIQzvSTiGORMmiVRIzrEeXU7XBLNk3cum9p8X.koOLLeRnrA5fpa"));
        System.out.println(matchesPassword("12345678", "$2a$10$KgY5Yn/HqOrBYp/YPRvxDuRLhgYqihepPcyrXdAxeP9K9n0zHNdGe"));
    }
}
