package com.company.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/21/23:46
 * @Description:
 */
public class _1120最长和谐子序列 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            while(end < n &&  nums[end] - nums[i] <= 1){
                end++;
            }
            // System.out.println( i + " " + end);
            if(nums[end - 1] - nums[i] ==  1){
                max = Math.max(max, end - i);
            }
        }
        return max;
    }
}
