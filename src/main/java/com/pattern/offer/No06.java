package com.pattern.offer;

import com.pattern.leetcode.simple.general.ListNode;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/">
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *  </a>
 *
 * @author lihui
 * @time 2021/5/21 4:01 下午
 */
public class No06 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] print = new int[stack.size()];
        int index = 0;
        while (!stack.empty()) {
            print[index++] = stack.pop();
        }
        return print;
    }

}
