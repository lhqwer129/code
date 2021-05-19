package com.pattern.leetcode.medium;

/**
 * @Description: https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @Author: lihui
 * @Date: 2021/2/8 4:20 下午
 */
public class LongestCommonPrefixClass {

    public static String longestCommonPrefix(String[] strs) {
        if (0 == strs.length) {
            return "";
        }

        String basicStr = strs[0];
        String finalStr = "";

        while(true) {
            boolean innerFlag = true;
            for (int cursor = 1; cursor < strs.length; cursor ++) {
                if (!strs[cursor].startsWith(basicStr)) {
                    innerFlag = false;
                    break;
                }
            }

            if (innerFlag) {
                finalStr = basicStr;
                break;
            }

            if (basicStr.length() == 1) {
                break;
            }

            basicStr = basicStr.substring(0, basicStr.length()-1);
        }

        return finalStr;
    }

    public static void main(String[] args) {
        String[] strs = {"hello", "hei", "1heive"};

        System.out.println(longestCommonPrefix(strs));
    }

}
