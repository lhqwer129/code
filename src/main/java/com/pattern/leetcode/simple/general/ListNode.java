package com.pattern.leetcode.simple.general;

/**
 * 链表
 *
 * @author lihui
 * @time 2020/8/17 8:33 下午
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
