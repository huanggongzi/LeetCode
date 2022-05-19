package com.company.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/19/23:49
 * @Description:
 */
public class _20220519最少移动次数使数组元素相等II {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = 0;
        int len = nums.length;
        // 0 1 2 3 4
        if(len % 2 == 0){
            mid = (nums[len / 2] + nums[len / 2 - 1]) / 2;
        }else{
            mid = nums[len / 2];
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            count = count + Math.abs(nums[i] - mid);
        }
        return count;
    }
}
