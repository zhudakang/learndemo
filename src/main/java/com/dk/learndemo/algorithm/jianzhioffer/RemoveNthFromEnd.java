package com.dk.learndemo.algorithm.jianzhioffer;

/**
 * @author :zhudakang
 * @description : RemoveNthFromEnd
 * @create : 2020/06/30
 */
public class RemoveNthFromEnd {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {


        //让一个节点比另一个快n+1个，那么一个到了终点，另一个正好是倒数第n个
        //保留初始节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        //找到了second的位置
        second.next = second.next.next;
        return dummy.next;
    }
}
