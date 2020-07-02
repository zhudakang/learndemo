package com.dk.learndemo.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : MiddleNode
 * @create : 2020/06/30
 */
public class MiddleNode {

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

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     */
    public ListNode middleNode(ListNode head) {
        //都放到一个容器里面

        List<ListNode> result = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            result.add(cur);
            cur = cur.next;
        }
        int size = result.size();
        if (size % 2 == 0) {
            return result.get(size / 2);
        } else {
            return result.get(((size + 1) / 2) - 1);
        }
    }


    /**
     * 快慢指针
     * 使用两个指针变量，刚开始都位于链表的第 1 个结点，一个永远一次只走 1 步，一个永远一次只走 2 步，一个在前，一个在后，同时走。这样当快指针走完的时候，慢指针就来到了链表的中间位置。
     *
     */
    public ListNode middleNode2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
