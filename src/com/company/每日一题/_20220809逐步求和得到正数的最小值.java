package com.company.每日一题;

public class _20220809逐步求和得到正数的最小值 {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum <= 1){
                min = Math.min(min, sum);
            }
        }
        return -min + 1;
    }
}
