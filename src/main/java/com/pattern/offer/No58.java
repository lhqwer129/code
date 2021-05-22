package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/">
 *     字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *     请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *     </a>
 *
 * @author lihui
 * @time 2021/5/22 2:06 下午
 */
public class No58 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = n; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }

        for (int j = 0; j < n; j++) {
            stringBuilder.append(chars[j]);
        }

        return stringBuilder.toString();
    }

}
