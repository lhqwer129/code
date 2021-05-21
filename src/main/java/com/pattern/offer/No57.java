package com.pattern.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/">
 *  I： 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。</a>
 *
 * <a href="https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/">
 * 二:
 *   </a>
 *
 *
 * @author lihui
 * @time 2021/5/19 8:17 下午
 */
public class No57 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < size; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = nums[i];
                result[1] = nums[map.get(nums[i])];
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }

    public int[][] findContinuousSequence(int target) {
        return null;
    }

}
