package com.company.蓄水池算法;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/17/23:17
 * @Description:
 */
public class 随机数索引 {
    int[] nums;
    Random random;

    public 随机数索引(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (len == 1) {
                    index = i;
                } else {
                    if (getNum(len) == 1) {
                        index = i;
                    }
                }
                len++;
            }
        }

        return index;
    }

    public int getNum(int i) {
        return random.nextInt(i) + 1;
    }
}
