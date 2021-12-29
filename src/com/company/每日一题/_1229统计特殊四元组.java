package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/29/23:30
 * @Description:
 */
public class _1229统计特殊四元组 {
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        if (len <= 3) {
            return 0;
        }
        int sum = 0;
        // Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    for (int f = k + 1; f < len; f++) {
                        if (nums[i] + nums[j] + nums[k] == nums[f]) {
                            //System.out.println(nums[i] + " " + nums[j] + " " + nums[k] + " " + nums[f]);
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
