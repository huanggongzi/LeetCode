package com.company.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/10/23:52
 * @Description:
 */
public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        if (nums.length <= 2) {
            return list;
        }

        // 如果不去重的版本
        for (int i = 0; i < nums.length; i++) {
            // 去重第一个数字
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }

            int left = i + 1;
            int right = nums.length - 1;


            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(getList(nums[i], nums[left++], nums[right--]));

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                }
            }

            //System.out.println(i);
        }
        return list;
    }

    public List getList(int num1, int num2, int num3) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        return list;
    }
}
