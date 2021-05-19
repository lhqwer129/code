package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author lihui
 * @time 2021/3/11 7:07 下午
 */
public class PreorderTraversalClass {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));

        return list;
    }

}
