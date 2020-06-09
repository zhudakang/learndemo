package com.dk.learndemo.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author :zhudakang
 * @description : MergeTwoLists
 * @create : 2020/06/09
 */
public class MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * DK解法和思路：把两个都放到list中，然后进行升序，最后输出
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<ListNode> tempList = new ArrayList<>();
        //可以先扔到一个容器里面，然后统一升序处理
        while (l1 != null) {
            ListNode temp = new ListNode(l1.val);
            tempList.add(temp);
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode temp = new ListNode(l2.val);
            tempList.add(temp);
            l2 = l2.next;
        }
        if (tempList.size() > 1) {
            tempList.sort((a, b) -> a.val - b.val);
        }
        ListNode head = tempList.get(0);
        ListNode other = head;
        for (int i = 1; i < tempList.size(); i++) {
            ListNode temp = tempList.get(i);
            other.next = temp;
            other = other.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);

    }

}
