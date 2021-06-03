package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">
 *     在排序数组中查找数字 I</a>
 *
 * @author lihui
 * @time 2021/6/2 10:25 下午
 */
public class No53 {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // 找出右边界
        while(l <= r) {
            int m = (l + r) /2;
            if (target >= nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int right = l;

        // todo： why?
        if (r >= 0 && nums[r] != target) {
            return 0;
        }

        l = 0; r = nums.length - 1;
        while(l <= r) {
            int m = (l + r) /2;
            if (target > nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int left = r;
        return right - left - 1;

    }

    public int missingNumber(int[] nums) {
        int l = 0; int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == m) {
                l = m + 1;
            } else {
                r = m -1;
            }
        }
        return l;
    }

    public boolean binarySearch(int[] nums, int target) {
        int l = 0; int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return true;
            } else if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

}
