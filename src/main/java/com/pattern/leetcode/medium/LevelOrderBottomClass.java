package com.pattern.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description: https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author lihui
 * @time 2021/3/16 8:28 下午
 */
public class LevelOrderBottomClass {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> treeValLists = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> treeValList = new ArrayList<>();
            for (TreeNode treeNode : treeNodeQueue) {
                treeValList.add(treeNode.val);
                if (treeNode.left != null) {
                    tmp.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    tmp.add(treeNode.right);
                }

            }
            treeValLists.add(treeValList);
            treeNodeQueue = tmp;
        }
        Collections.reverse(treeValLists);
        return treeValLists;
    }



}
