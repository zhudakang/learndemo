package com.dk.learndemo.algorithm.linkedlist;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/7/5
 */
public class MiddleNode {

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * */
    public ListNode middleNode(ListNode head) {

        //直接想法是两次遍历第一次求出链表长度 第二次求出数组的中间结点
        //第二种思想，找一个数组存下来所有的链表结点
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    public ListNode middleNode2(ListNode head) {
        //快指针到终点 直接return slow就行
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
