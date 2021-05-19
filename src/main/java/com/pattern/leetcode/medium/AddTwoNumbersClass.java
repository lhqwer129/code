package com.pattern.leetcode.medium;

/**
 * @Description: https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @Author: lihui
 * @Date: 2021/2/8 3:25 下午
 */
public class AddTwoNumbersClass {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode temp1 = new ListNode(4);
        ListNode temp2 = new ListNode(3);
        temp1.next = temp2;
        l1.next = temp1;
        ListNode temp3 = new ListNode(6);
        ListNode temp4 = new ListNode(4);
        temp3.next = temp4;
        l2.next = temp3;
    }

}
