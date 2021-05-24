package com.pattern.offer;

/**
 * <a href= "https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">
 *    斐波那契数列
 *     </>
 *
 * @author lihui
 * @time 2021/5/24 1:54 下午
 */
public class No10 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0;
        int b = 1;
        int temp = 0;

        for (int i = 2; i<=n; i ++) {
            temp = (a + b)%1000000007;
            a = b;
            b = temp;
        }

        return temp;
    }

}
