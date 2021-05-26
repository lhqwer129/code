package com.pattern.offer;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/">
 *  调整数组顺序使奇数位于偶数前面
 *     </a>
 *
 * @author lihui
 * @time 2021/5/25 9:37 下午
 */
public class No21 {

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }

        int i = 0;
        int j = nums.length - 1;

        while(i < j) {
            if (odd(nums[i])) {
                i ++;
                continue;
            }

            if (even(nums[j])) {
                j --;
                continue;
            }

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i ++;
            j --;
        }
        return nums;
    }

    private boolean odd(int number) {
        return number%2 != 0;
    }

    private boolean even(int number) {
        return number%2 == 0;
    }

    public static void main(String[] args) {
        No21 no21 = new No21();
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(no21.exchange(nums)));
    }

}
