package com.pattern.leetcode.medium;

/**
 * Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author lihui
 * @time 2021/4/6 8:14 下午
 */
public class RemoveDuplicatesClass {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int i = 2;
        int j = 2;
        while (i < n) {
            if (nums[i] != nums[i - 2]) {
                nums[j++] = nums[i];
            }
            i ++ ;
        }
        return j;
    }
}
