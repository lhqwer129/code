package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author lihui
 * @time 2021/3/24 8:04 下午
 */
public class MergeTreesClass {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode mergeThree;
        if (root1 == null && root2 == null) {
            return null;
        }

        int value1 = root1 == null ? 0 : root1.val;
        int value2 = root2 == null ? 0 : root2.val;
        mergeThree = new TreeNode(value1 + value2);

        mergeThree.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        mergeThree.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return mergeThree;
    }

}
