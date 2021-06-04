package com.pattern.offer;

import com.pattern.leetcode.medium.TreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/">
 *     对称二叉树
 *     </a>
 *
 * @author lihui
 * @time 2021/6/3 7:33 下午
 */
public class No28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
