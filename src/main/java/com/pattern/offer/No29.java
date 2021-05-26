package com.pattern.offer;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">顺时针打印矩阵
 *     </a>
 *
 * @author lihui
 * @time 2021/5/26 3:47 下午
 */
public class No29 {

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null) {
            return null;
        }
        if(matrix.length ==0 || matrix[0].length == 0) {
            return new int[]{};
        }
        
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int rowTop = 0;
        int rowBottom = matrix.length - 1;
        int[] orderNums = new int[(colRight+1) * (rowBottom + 1)];

        // 确定终止条件
        int index = 0;
        while(colLeft <= colRight && rowTop <= rowBottom) {
            // 上
            for (int i = colLeft; i <= colRight; i++) {
                orderNums[index++] = matrix[rowTop][i];
            }

            // 右
            for (int j = rowTop + 1; j <= rowBottom; j++) {
                orderNums[index++] = matrix[j][colRight];
            }

            // 下
            for (int m = colRight - 1; m >= colLeft; m--) {
                if (rowBottom == rowTop) {
                    continue;
                }
                orderNums[index++] = matrix[rowBottom][m];
            }

            // 左
            for (int n = rowBottom - 1; n >= rowTop + 1 ; n--) {
                if (colLeft == colRight) {
                    continue;
                }
                orderNums[index++] = matrix[n][colLeft];
            }

            colLeft ++;
            colRight --;
            rowTop ++;
            rowBottom --;
        }
        return orderNums;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(nums)));
    }

}
