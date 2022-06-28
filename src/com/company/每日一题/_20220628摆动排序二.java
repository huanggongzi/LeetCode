package com.company.每日一题;

import java.util.Arrays;

public class _20220628摆动排序二 {public void wiggleSort(int[] nums) {
    // 先做出来
    Arrays.sort(nums);
    int len = nums.length;
    int[] array = new int[len];
    int count = len - 1;

    for(int i = 1; i < len; i = i + 2){
        array[i] = nums[count--];
    }
    for(int i = 0; i < len; i = i + 2){
        array[i] = nums[count--];
    }
    for(int i = 0; i < array.length; i++){
        nums[i] = array[i];
    }
}
}
