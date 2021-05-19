package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author lihui
 * @time 2021/3/10 8:25 下午
 */
public class MinDepthClass {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<TreeNode> temp;
        int minDepth = 0;
        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()) {
            temp = new LinkedList<>();
            for (TreeNode treeNode : treeNodeQueue) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
                if (treeNode.left == null && treeNode.right == null) {
                    minDepth ++;
                    return minDepth;
                }
            }
            treeNodeQueue = temp;
            minDepth ++;
        }

        return minDepth;
    }

}
