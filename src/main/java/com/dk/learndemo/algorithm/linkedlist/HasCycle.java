package com.dk.learndemo.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :zhudakang
 * @description : HasCycle
 * @create : 2020/06/09
 */
public class HasCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     *
     *
     * DK解法
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        //判断有没有环使用快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null){
            if(fast.next == null){
                return false;
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
            if(fast == null || slow==null){
                return false;
            }
            if(fast.val == slow.val){
                return true;
            }
        }
        return false;
    }

    /**
     * 官方解法
     * 空间复杂度：O(1)O(1)
     * */
    public boolean hasCycle2(ListNode head) {
        //官方解法比我的优雅
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 借助MAP和SET都是很好的思想
     * */
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
