package com.company.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _20220804非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            sum = sum + nums[i];
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int i = nums.length - 1;
        for(i = i; i >= 0; i--){
            if(sum - count < count){
                break;
            }
            list.add(nums[i]);
            count = count + nums[i];
        }

        return list;

    }
}
