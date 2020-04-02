package com.dk.learndemo.leetcode;

import java.util.List;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/4/2
 */
public class ReverseList2 {


    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * mn 是从1开始的
     *
     * 思路 需要保存一个 con 和tail
     * 用于最后的翻转
     *
     * 子链表的翻转需要借助第三方变量来进行
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        //cur初始化为head ； prev 为null
        ListNode cur = head;
        ListNode prev = null;

        //相当于找到m的位置哈
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }


        //为了最后的整体链接
        ListNode con = prev, tail = cur;

        //第三方临时变量
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        //最后翻转整个链表 这个if无伤大雅
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode listNode = reverseBetween(head, 2, 4);

        System.out.println();
    }

}
