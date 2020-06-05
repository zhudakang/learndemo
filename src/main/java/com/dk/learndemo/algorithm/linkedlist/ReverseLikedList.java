package com.dk.learndemo.algorithm.linkedlist;

/**
 * @author :zhudakang
 * @description : ReverseLikedList
 * @create : 2020/06/05
 */
public class ReverseLikedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 借助存储空间
     * 5->4 ->3 ->2
     * 5<-4<-3<-
     * 只要更改指向就好了
     *
     *
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * dk解法
     *      * 5->4 ->3 ->2
     *      * 5<-4<-3<-
     * 1. cur 当前是head节点也就是5
     *    cur 不为空 nexttemp = 4
     *    那么让cur之后指向null
     *    5指向了null
     *    接下来
     *    让pre 也就是 cur之前的节点
     *    让pre 为第一个数字5
     *    然后让当前节点为4
     *    2.到了5 和4之后
     *    当前是4了
     *    反转
     *    4不为空
     *    进去之后 找到next 为3
     *    然后让4的下一个为5就好了
     *
     *
     * */
    private ListNode reverseList1(ListNode head) {
        //定义当前指针和前一个指针
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            //这一步是最主要的更改指针
            cur.next = pre;
            //然后让pre为cur
            pre = cur;
            //cur 是下一个指针
            cur = nextTemp;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
