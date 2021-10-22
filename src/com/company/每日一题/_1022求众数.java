package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/22/23:43
 * @Description:
 */
public class _1022求众数 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int num = nums.length / 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.put(nums[i], ++value);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(Integer key : map.keySet()){
            if(map.get(key) > num){
                list.add(key);
            }
        }
        return list;
    }
}
