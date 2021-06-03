package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/">
 *     礼物的最大价值</a>
 *
 * @author lihui
 * @time 2021/6/2 4:10 下午
 */
public class No47 {

    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        int curMax = dp[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][i] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
                }
                curMax = Math.max(curMax, dp[i][j]);
            }
        }
        return curMax;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,5},{3,2,1}};


    }

}
