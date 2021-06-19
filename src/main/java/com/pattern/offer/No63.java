package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/">
 *     股票的最大利润</a>
 *
 * @author lihui
 * @time 2021/6/10 10:44 下午
 */
public class No63 {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min >= prices[i]) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - res);
            }
        }
        return res;
    }

}
