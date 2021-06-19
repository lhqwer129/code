package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/">
 *     圆圈中最后剩下的数字</a>
 *
 * @author lihui
 * @time 2021/6/18 2:04 下午
 */
public class No62 {

    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i < n ; i ++) {
            x = (x + m) % i;
        }

        return x;
    }

}
