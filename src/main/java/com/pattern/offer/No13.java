package com.pattern.offer;

/**
 * <a href = "https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/">
 *     机器人运动范围 </a>
 *
 * @author lihui
 * @time 2021/5/25 10:43 上午
 */
public class No13 {
    private boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(m , n, 0, 0, k);
    }

    private int dfs(int m, int n, int i, int j, int k) {
        // 边界条件判断
        if (i >= m || j >= n || visited[i][j] || (sum(i) + sum(j) > k)) {
            return 0;
        }

        visited[i][j] = true;
        return 1 + dfs(m, n, i+1, j, k) + dfs(m, n, i, j + 1, k);
    }

    private int sum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += sum%10;
            n = n/10;
        }
        return sum;
    }

}
