package com.pattern.offer;

import java.util.HashMap;

/**
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/">
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *  </a>
 *
 * @author lihui
 * @time 2021/5/19 3:41 下午
 */
public class No03 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i : nums) {
            if (hashMap.containsKey(i)) {
                return i;
            }
            hashMap.put(i , 1);
        }

        return 0;
    }

}
