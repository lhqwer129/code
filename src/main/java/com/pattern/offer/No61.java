package com.pattern.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">
 *     扑克牌中的顺子
 *     </a>
 *
 * @author lihui
 * @time 2021/6/4 8:48 下午
 */
public class No61 {

    public boolean isStraight(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int min = 14;
        int max = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) {
                continue;
            }
            res.add(nums[i]);
            if (res.contains(nums[i])) {
                return false;
            }
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        return max - min < 5;
    }

}
