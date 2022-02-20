package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/20:43
 * @Description:
 */
public class _20220219煎饼排序 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        // boolean flag = true;
        int start = 0;
        int end = arr.length - 1;
        while(end != 0){
            int index = getMax(arr, start, end);
            fanzhuan(arr, start, index);
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            fanzhuan(arr, start, end);
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            list.add(index + 1);
            list.add(end + 1);
            end--;
        }
        return list;
    }

    public int getMax(int[] arr, int start, int end){
        int index = 0;
        int max = -1;
        for(int i = start; i <= end; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public void fanzhuan(int[] arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
