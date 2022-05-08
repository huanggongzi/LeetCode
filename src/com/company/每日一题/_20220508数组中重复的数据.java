package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/08/23:12
 * @Description:
 */
public class _20220508数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if(nums[num - 1] > 0){
                nums[num - 1] = -nums[num - 1];
            }else{
                list.add(Math.abs(nums[i]));
            }
        }

        return list;
    }
}
