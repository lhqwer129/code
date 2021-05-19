package com.pattern.leetcode.simple;

/**
 *
 *@author lihui
 *@time 2020/11/22 下午3:27
 */
class Solution {
    public int romanToInt(String s) {
        return 0;
    }

    public static void main(String[] args) {
        // write your code here

        int a = 2;

        switch (a) {
            case 1:  a = a + 1;
                break;

            case 2:
                if (a == 2) {
                    a = a + 2;
                    break;
                }
                a = a + 3;
                break;
            default:
                a = a + 4;
                break;
        }

        System.out.println(a
        );
    }
}
