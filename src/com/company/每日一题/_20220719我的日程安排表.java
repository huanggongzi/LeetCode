package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

public class _20220719我的日程安排表 {
    List<int[]> one;

    List<int[]> two;
    public _20220719我的日程安排表() {
        one = new ArrayList<>();
        two = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // 先去判断是否在两个里面
        for(int[] arr : two){
            int left = arr[0];
            int right = arr[1];
            if(start < right && end > left){
                return false;
            }
        }

        // 通过之后，查看当前相交有二次的地方
        for(int[] arr : one){
            int left = arr[0];
            int right = arr[1];
            if(start < right && end > left){
                two.add(new int[]{Math.max(left, start), Math.min(right, end)});
            }
        }
        one.add(new int[]{start, end});
        return true;
    }
}
