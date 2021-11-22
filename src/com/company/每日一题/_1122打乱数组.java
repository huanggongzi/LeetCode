package com.company.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/22/0:37
 * @Description:
 */
public class _1122打乱数组 {
    int[] nums;
    int n;
    Random random = new Random();

    public _1122打乱数组(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        for(int i = 0; i < n; i++){
            swap(arr, i, i + random.nextInt(n - i));
        }
        return arr;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
