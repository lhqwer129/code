package com.pattern.leetcode.simple;

import java.util.Stack;

/**
 * @author lihui
 * @time 2020/8/7 7:21 下午
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (
                p == null && q == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();



        return true;

    }


     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
