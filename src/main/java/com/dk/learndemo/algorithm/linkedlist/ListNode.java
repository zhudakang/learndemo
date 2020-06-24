package com.dk.learndemo.algorithm.linkedlist;

/**
 * @author :zhudakang
 * @description : ListNode
 * @create : 2020/06/09
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
