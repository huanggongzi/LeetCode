package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/26/23:42
 * @Description:
 */
public class _1026下一个更大元素一 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 垃圾算法算一下
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        int len = nums2.length;
        int[] maxArr = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int start = map.get(nums1[i]);
            int j = 0;
            for(j = start + 1; j < len; j++){
                if(nums2[j] > nums1[i]){
                    maxArr[i] = nums2[j];
                    break;
                }
            }
            if(j == len){
                maxArr[i] = -1;
            }
        }
        return maxArr;
    }
}
