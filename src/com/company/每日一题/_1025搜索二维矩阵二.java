package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/25/22:32
 * @Description:
 */
public class _1025搜索二维矩阵二 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix.length;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < len && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        return false;
    }
}
