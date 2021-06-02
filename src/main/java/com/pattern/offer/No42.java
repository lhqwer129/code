package com.pattern.offer;

import com.sun.xml.internal.xsom.impl.scd.Axis;
import com.sun.xml.internal.xsom.impl.scd.Axis.ModelGroupAxis;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/">
 *     连续子数组的最大和</a>
 *
 * @author lihui
 * @time 2021/6/1 11:17 下午
 */
public class No42 {

    /**
     * 状态方程是以为结尾的子序列的合
     */
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i-1], 0);
            max = Math.max(nums[i], max);
        }
        Object
        return max;
    }

}
