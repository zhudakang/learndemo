package com.dk.learndemo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/4/2
 */
public class ReverseList {

    /**
     * 思路 入参是链表的头
     * 需要把head -> second
     * 变成head -> null
     * second - > head
     * 先设定当前的cur  把head 赋值给Cur
     * 链表对java  很不友好，这不让我过！！
     *
     * */
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
}
