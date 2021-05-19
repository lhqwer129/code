package com.pattern.leetcode.simple;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
 *
 * @author lihui
 * @time 2020/9/8 8:39 下午
 */
public class MaxNum {

    int getMaxNum(int[] nums) {
        int s = nums.length;
        if (s < 3) {
            return (nums[0] - 1) * (nums[1] - 1);
        }

        int a = nums[0];
        int b = nums[1];
        for (int i = 2; i < s; i++) {
            if (nums[i] > a || nums[i] > b) {
                a = Math.max(a, b);
                b = nums[i];
            }
        }

        return (a - 1) * (b - 1);
    }

}
