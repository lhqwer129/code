package com.pattern.offer;

import com.pattern.leetcode.medium.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/">删除列表节点</a>
 *
 *
 * @author lihui
 * @time 2021/6/1 11:09 下午
 */
public class No18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        while(cur != null) {
            if (cur.val == val) {
                pre.next = pre.next.next;
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }

}
