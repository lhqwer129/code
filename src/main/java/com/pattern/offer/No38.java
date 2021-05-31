package com.pattern.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/">
 *     字符串排列</a>
 *
 * @author lihui
 * @time 2021/5/29 5:16 下午
 */
public class No38 {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (hashSet.contains(c[i])) {
                continue;
            }
            hashSet.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

}
