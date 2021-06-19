package com.pattern.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/">
 *     数组中数字出现的次数</a>
 *
 * @author lihui
 * @time 2021/6/6 3:26 下午
 */
public class No56 {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        // 异或操作，一个数与0异或的结果等于它本身，两个相同数异或等于0
        for (int n : nums) {
            ret ^= n;
        }

        int target = 1;
        while((target & ret)==0){
            target = target<<1;
        }

        int a = 0, b = 0;
        for(int num:nums){
            if((num & target)==0){
                a ^= num;
            }else{
                b ^= num;
            }
        }

        return new int[]{a,b};
    }


}
