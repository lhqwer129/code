package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/">
 *     打印从1到最大的n位数</a>
 *
 * @author lihui
 * @time 2021/6/6 12:11 下午
 */
public class No17 {

    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[] {};
        }
        int maxNumber = maxNumber(n);
        int[] num = new int[maxNumber];

        for(int i = 0; i < maxNumber; i ++) {
            num[i] = i + 1;
        }
        return num;
    }

    private int maxNumber(int n) {
        return (int)Math.pow(10, n) - 1;
    }

    static class Solution {
        StringBuilder res;
        int count = 0, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder(); // 数字字符串集
            num = new char[n]; // 定义长度为 n 的字符列表
            dfs(0); // 开启全排列递归
            res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
            return res.toString(); // 转化为字符串并返回
        }
        void dfs(int x) {
            if(x == n) { // 终止条件：已固定完所有位
                res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
                return;
            }
            for(char i : loop) { // 遍历 ‘0‘ - ’9‘
                num[x] = i; // 固定第 x 位为 i
                dfs(x + 1); // 开启固定第 x + 1 位
            }
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.printNumbers(3));
        }
    }

}
