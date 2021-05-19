package com.pattern.leetcode.medium;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/2/18 7:05 下午
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
