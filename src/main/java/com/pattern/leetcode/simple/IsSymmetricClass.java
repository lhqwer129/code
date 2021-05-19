package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author lihui
 * @time 2021/2/19 8:38 下午
 */
public class IsSymmetricClass {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }

        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        return (treeNode1.val == treeNode2.val)
                && isMirror(treeNode1.left, treeNode2.right)
                && isMirror(treeNode1.right, treeNode2.left);

    }

    public boolean checkMirrorByQueue(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;

    }

}
