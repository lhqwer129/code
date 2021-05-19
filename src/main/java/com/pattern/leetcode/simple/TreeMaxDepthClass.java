package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/3/9 8:54 下午
 */
public class TreeMaxDepthClass {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    public int maxDepthByQueue(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(treeNode);
        Queue<TreeNode> temp;
        int res = 1;
        while(!treeNodeQueue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode queue : treeNodeQueue) {
                if (queue.left != null) {
                    temp.add(queue.left);
                }

                if (queue.right != null) {
                    temp.add(queue.right);
                }
            }
            treeNodeQueue = temp;
            res ++;
        }

        return res;

    }

}
