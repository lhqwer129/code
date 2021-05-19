package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author lihui
 * @time 2021/2/18 6:09 下午
 */
public class MaxDepthClass {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
