package com.pattern.offer;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">
 *   两个队列实现栈</a>
 *
 * @author lihui
 * @time 2021/5/26 1:15 下午
 */
public class No09 {

    class CQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.empty()) {
                while(!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }

            if (stack2.empty()) {
                return -1;
            } else {
                return stack2.pop();
            }

        }
    }

}
