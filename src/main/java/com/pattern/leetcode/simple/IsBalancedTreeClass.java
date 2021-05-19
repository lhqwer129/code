package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * @author lihui
 * @time 2021/3/9 8:45 下午
 */
public class IsBalancedTreeClass {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public Integer maxDepth(TreeNode root) {
        if (root ==  null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
