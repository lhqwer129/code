package com.pattern.offer;

import com.pattern.leetcode.medium.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/">
 *     二叉搜索树数的第k大节点</a>
 *
 * @author lihui
 * @time 2021/6/3 8:06 下午
 */
public class No54 {

    /**
     * 中序遍历单调递减
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                TreeNode temp = stack.pop();
                i++;
                if (i == k) {
                    return temp.val;
                }
                root = temp.left;
            }
        }
        return 0;
    }

}
