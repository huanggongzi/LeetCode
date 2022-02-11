package com.company.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/11/22:37
 * @Description:
 */
public class _20220211学生分数的最小差值 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 100000;
        int len = nums.length;
        if(len <= k){
            return nums[len - 1] - nums[0];
        }
        int index = 0;
        while(index + k <= nums.length){
            min = Math.min(nums[index + k - 1] - nums[index], min);
            index++;
        }
        return min;
    }
}
