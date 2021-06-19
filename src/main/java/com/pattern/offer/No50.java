package com.pattern.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/">
 *     第一个只出现一次的字符</a>
 *
 * @author lihui
 * @time 2021/6/16 9:00 下午
 */
public class No50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> maps = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(maps.containsKey(c)) {
                maps.put(c, -1);
            } else {
                maps.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: maps.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

}
