package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/">
 *     把数字翻译成字符串</a>
 *
 * @author lihui
 * @time 2021/6/4 11:42 下午
 */
public class No46 {

    /**
     * 青蛙跳台阶，dp[i] 代表以i
     *   为结尾的数字的翻译方案数量。
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1;
        int b = 1;

        for (int i = 2; i <= str.length(); i ++) {
            int c = 0;
            String temp = str.substring(i - 2 , i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                c = a + b;
             } else {
                c = a;
            }
            b = a;
            a = c;
        }
        return a;
    }



}
