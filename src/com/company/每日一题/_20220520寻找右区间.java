package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/20/23:57
 * @Description:
 */
public class _20220520寻找右区间 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            // 遍历每一个
            int index = -1;
            int end = intervals[i][1];
            int minValue = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                int start = intervals[j][0];
                if(start >= end && start < minValue){
                    minValue = start;
                    index = j;
                }
            }
            result[i] = index;
        }
        return result;
    }
}
