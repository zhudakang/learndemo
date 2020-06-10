package com.dk.learndemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description : PasswordUtils
 * @Date : 2019/11/5
 * @Author :
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
        System.out.println(encodePassword("12345678"));
    }
}
