package com.pattern.offer;

import com.pattern.leetcode.medium.TreeNode;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/">
 *     二叉树镜像</a>
 *  1、递归
 *  2、非递归
 *
 * @author lihui
 * @time 2021/5/27 4:04 下午
 */
public class No27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }


    public TreeNode mirrorTreeStack(TreeNode root) {
        if(root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }








}
