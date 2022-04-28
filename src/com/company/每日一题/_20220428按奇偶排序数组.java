package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/28/23:22
 * @Description:
 */
public class _20220428按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            if(nums[left] % 2 == 0){
                left++;
            }else{
                swap(nums, left, right);
                right--;
            }
        }

        return nums;
    }


    public void swap(int[] nums, int i, int j){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }
}
