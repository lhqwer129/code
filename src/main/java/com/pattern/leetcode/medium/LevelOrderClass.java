package com.pattern.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author lihui
 * @time 2021/2/18 7:30 下午
 */
public class LevelOrderClass {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> nodeValListList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodeValList = new ArrayList<>();
            while(size > 0) {
                TreeNode treeNode = queue.poll();
                nodeValList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                size --;
            }
            nodeValListList.add(nodeValList);
        }

        return nodeValListList;

    }

}
