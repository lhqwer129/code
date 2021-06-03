package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/qiu-12n-lcof/">
 *     1 + ... + n</a>
 *
 * @author lihui
 * @time 2021/6/3 12:42 下午
 */
public class No64 {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
