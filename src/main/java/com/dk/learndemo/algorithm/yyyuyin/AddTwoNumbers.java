package com.dk.learndemo.algorithm.yyyuyin;

/**
 * @author :zhudakang
 * @description : AddTwoNumbers
 * @create : 2020/07/03
 */
public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，
     * 该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，
     * 而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //预先指针，是头结点，防止后面找不到
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            //如果为空就使用0
            int x = l1 == null ? 0 : l1.val;
            //如果为空就使用0
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            //carry是上一次剩下的，看看有没有多余
            carry = sum / 10;
            //个位
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            //把剩余部分弄完
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //为什么最后，还有1呢，因为可能两个都是三位数，最后加出来应该是四位数，所以再加一位就好了
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
