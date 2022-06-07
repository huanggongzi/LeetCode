package com.company.每日一题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/06/07/23:45
 * @Description:
 */
public class _20220607爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        // 排序 + 二分
        Arrays.sort(piles);

        int left = 1;
        // 最大的
        int right =  piles[piles.length - 1];
        int k = 0;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(isSucess(piles, h, mid)){
                k = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return k;
    }

    public boolean isSucess(int[] piles, int h, int k){
        int num = 0;
        for(int i = 0; i < piles.length; i++){
            int value = piles[i];

            int p1 = value % k;
            int p2 = value / k;

            if(p1 > 0){
                num = num + p2 + 1;
            }else{
                num = num + p2;
            }
        }
        if(num <= h){
            return true;
        }
        return false;
    }
}
