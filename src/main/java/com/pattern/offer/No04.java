package com.pattern.offer;

/**
 * <a href="https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/">
 *     在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *     </a>
 *
 * @author lihui
 * @time 2021/5/21 3:19 下午
 */
public class No04 {

    /**
     * 从右上角开始查找
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rowSize = matrix.length;
        int columnSize = matrix[0].length;

        int startRow = 0;
        int startCol = columnSize -1;

        while (startRow < rowSize && startCol >=0) {
            if (target == matrix[startRow][startCol]) {
                return true;
            }

            if (target < matrix[startRow][startCol]) {
                startCol --;
            } else {
                startRow ++;
            }
        }
        return false;
    }
}
