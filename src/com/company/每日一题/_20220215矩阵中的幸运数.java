package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/15/23:38
 * @Description:
 */
public class _20220215矩阵中的幸运数 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j < matrix[0].length; j++){
                // 找出最小的那一个数
                if(min > matrix[i][j]){
                    min = matrix[i][j];
                    index = j;
                }
            }
            // 看这个最大的数 在这一列 是不是最大的
            int max = -1;
            for(int j  = 0; j < matrix.length; j++){
                max = Math.max(max, matrix[j][index]);
            }
            if(max == min){
                list.add(max);
            }
        }
        return list;
    }
}
