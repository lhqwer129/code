package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/">
 *     旋转数组的最小数字
 *     </a> </br>
 *  <tag>
 *      * 二分查找
 *  </tag>
 *
 * @author lihui
 * @time 2021/5/25 9:10 下午
 */
public class No11 {

    /**
     * 根据查找旋转数组最小值的目的，通过相关逻辑不断缩小low,high区间，知道low == high，退出循环，区间最后一个元素即我们要找的最小值
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }




}
