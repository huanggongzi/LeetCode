package com.company.每日一题;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/12/0:11
 * @Description:
 */
public class _20220112递增的三元子序列 {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return false;
        }

        // 左边有无比它小的
        int[] arrMin = new int[len];
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > min) {
                arrMin[i] = 1;
            } else {
                min = nums[i];
            }
        }

        // 右边有没有比他大的
        int[] arrMax = new int[len];
        int max = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < max) {
                arrMax[i] = 1;
            } else {
                max = nums[i];
            }
        }

        for (int i = 1; i < len; i++) {
            if (arrMin[i] == 1 && arrMax[i] == 1) {
                return true;
            }
        }

        return false;
    }
    /**
     * O(1)的空间复杂度
     */
    public boolean increasingTriplet1(int[] nums) {
        int len = nums.length;
        if(len <= 2){
            return false;
        }

        int firMin = Integer.MAX_VALUE;
        int sedMin = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(nums[i] > sedMin){
                return true;
            }else if(nums[i] > firMin){
                sedMin = nums[i];
            }else{
                firMin = nums[i];
            }
        }

        return false;
    }

}
