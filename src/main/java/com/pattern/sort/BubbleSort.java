package com.pattern.sort;

import java.util.Arrays;

/**
 * Description: 冒泡排序是非常好理解的，以从小到大排序为例，每一轮排序就找出未排序序列中最大值放在最后。
 *
 * 1、每一轮将最大的数冒泡在数组最后
 * 2、下一轮就只需要比较数组中剩余的未排序的数就可以了
 *
 * @author lihui
 * @time 2021/6/14 7:58 下午
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 7, 4};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }

}
