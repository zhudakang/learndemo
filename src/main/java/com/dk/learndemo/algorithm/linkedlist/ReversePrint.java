package com.dk.learndemo.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author :zhudakang
 * @description : ReversePrint
 * @create : 2020/07/15
 */
public class ReversePrint {

    /**
     *
     输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     示例 1：
     输入：head = [1,3,2]
     输出：[2,3,1]
     * */
    public int[] reversePrint(ListNode head) {


            //这种倒叙优先想到辅助栈
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            int size = stack.size();
            int[] print = new int[size];
            for (int i = 0; i < size; i++) {
                print[i] = stack.pop().val;
            }
            return print;
        }

}
