package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/10/22:04
 * @Description:
 */
public class _1110提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 当前的持续时间
        if(timeSeries.length == 0){
            return duration;
        }
        int sum = duration;
        for(int i = 1; i < timeSeries.length; i++){
            if(timeSeries[i] - timeSeries[i - 1] >= duration){
                sum = sum + duration;
            }else{
                sum = sum + (timeSeries[i] - timeSeries[i - 1]);
            }
        }
        return sum;
    }
}
