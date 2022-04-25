package com.company.每日一题;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/25/23:44
 * @Description:
 */
public class _20220425随机数索引 {
    int[] nums;
    Random random;

    public _20220425随机数索引(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int[] bag = new int[1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (count == 0) {
                    bag[0] = i;
                } else {
                    int index = random.nextInt(count + 1);
                    // System.out.println(index);
                    if (index == 1) {
                        bag[0] = i;
                    }
                }
                count++;
            }
        }
        return bag[0];
    }
}
