package com.dk.learndemo.algorithm.kuaishou;

import java.net.Inet6Address;
import java.net.InetAddress;

/**
 * @author :zhudakang
 * @description : ValidIPAddress
 * @create : 2020/06/15
 */
public class ValidIPAddress {


    /**
     * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
     * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
     * <p>
     * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
     * <p>
     * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。
     * 比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
     * 而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
     * 所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
     * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 
     * 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
     * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
     * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
     */
    public String validIPAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
        } catch (Exception e) {
        }
        return "Neither";
    }
}
