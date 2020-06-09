package com.dk.learndemo.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : KthToLast
 * @create : 2020/06/09
 */
public class KthToLast {

    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 注意：本题相对原题稍作改动
     * 示例：
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     * 给定的 k 保证是有效的。
     * */
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        List<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList.get(arrayList.size() - k);
    }
}
