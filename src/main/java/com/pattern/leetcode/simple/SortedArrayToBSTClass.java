package com.pattern.leetcode.simple;

import com.pattern.leetcode.medium.TreeNode;

/**
 * Description: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author lihui
 * @time 2021/2/24 7:55 下午
 */
public class SortedArrayToBSTClass {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums, left, mid-1);
        treeNode.right = helper(nums, mid+1, right);
        return treeNode;
    }

}
