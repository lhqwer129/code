package com.pattern.offer;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/">
 *  栈的压入、弹出序列
 *     </a>
 *
 * @author lihui
 * @time 2021/6/3 9:01 下午
 */
public class No31 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushed.length;) {
            stack.push(pushed[i]);
            if (pushed[i] == popped[j]) {
                stack.pop();
                j ++;
            }

            while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j ++;
            }
            i ++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

}
