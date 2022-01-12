package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/13/0:15
 * @Description:
 */
public class _20220113至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        int temp = max;

        //System.out.println(max);
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                max = Math.max(max, nums[i] * 2);
            }
        }
        //System.out.println(max);
        if (temp == max) {
            return index;
        }
        return -1;
    }
}
