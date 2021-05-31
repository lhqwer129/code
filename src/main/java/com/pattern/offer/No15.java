package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/">
 *     二进制中1的个数</a>
 *
 * @author lihui
 * @time 2021/5/31 4:09 下午
 */
public class No15 {

    public static int hammingWeight(int n) {

        int sum = 0;
        while(n != 0) {
            sum += n & 1;
            n >>>=1;
        }
        return sum;

    }

}
