package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/jian-sheng-zi-lcof/">剪绳子</a>
 *
 * @author lihui
 * @time 2021/5/31 5:50 下午
 */
public class No14 {

    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
