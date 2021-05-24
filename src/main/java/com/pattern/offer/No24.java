package com.pattern.offer;

import com.pattern.leetcode.simple.general.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/">
 *     定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。</a>
 *
 * @author lihui
 * @time 2021/5/22 3:01 下午
 */
public class No24 {

    /**
     * 递归
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 非递归
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        ListNode reverseNode = reverseList(head1);
        System.out.println("123");
    }


}
