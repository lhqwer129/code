package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/same-tree/
 *
 * @author lihui
 * @time 2021/2/19 9:03 下午
 */
public class IsSameTreeClass {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    // 非递归



}
