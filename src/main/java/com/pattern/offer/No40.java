package com.pattern.offer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/">
 *  输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  </a>
 *
 * @author lihui
 * @time 2021/5/22 1:40 下午
 */
public class No40 {


    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        int[] leastNumbers = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i ++) {
            leastNumbers[i] = arr[i];
        }
        return leastNumbers;

    }



}
