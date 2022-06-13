package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/13/23:55
 * @Description:
 */
public class _20220613高度检查器 {
    public int heightChecker(int[] heights) {
        int[] array = getNewArray(heights);
        Arrays.sort(heights);
        int count = 0;
        int len = heights.length;
        if(len <= 0){
            return count;
        }

        for(int i = 0; i < len; i++){
            if(array[i] != heights[i]){
                count++;
            }
        }

        return count;

    }


    public int[] getNewArray(int[] heights){
        int[] array = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            array[i] = heights[i];
        }
        return array;
    }
}
