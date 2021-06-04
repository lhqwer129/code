package com.pattern.offer;

import com.pattern.leetcode.medium.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/">
 *     从上到下打印二叉树</a>
 *
 * @author lihui
 * @time 2021/6/3 7:50 下午
 */
public class No32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[] {};
        }

        List<Integer> collectionNode = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            collectionNode.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        int[] collectionArray = new int[collectionNode.size()];
        for(int i = 0; i< collectionNode.size(); i++) {
            collectionArray[i] = collectionNode.get(i);
        }
        return collectionArray;
    }
}
