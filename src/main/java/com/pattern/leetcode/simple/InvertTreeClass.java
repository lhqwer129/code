package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author lihui
 * @time 2021/3/17 8:38 下午
 */
public class InvertTreeClass {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode treeNode = new TreeNode(root.val, root.left, root.right);

        root.left = treeNode.right;
        root.right = treeNode.left;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
