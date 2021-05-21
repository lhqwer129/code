package com.pattern.offer;

/**
 * <a href>
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * </a>
 *
 * @author lihui
 * @time 2021/5/21 4:22 下午
 */
public class No05 {

    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }



}
