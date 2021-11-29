package com.company.每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/29/1:11
 * @Description:
 */
public class _1129第K个最小的素数分数 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<DTO> priorityQueue = new PriorityQueue<>(new Comparator<DTO>() {
            @Override
            public int compare(DTO o1, DTO o2) {
                if (o1.value - o2.value > 0) {
                    return 1;
                } else if (o1.value - o2.value < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                DTO dto = new DTO();
                dto.i = i;
                dto.j = j;
                dto.value = ((double) arr[i]) / ((double) arr[j]);
                priorityQueue.add(dto);
            }
        }

        int[] arr1 = new int[2];
        while (!priorityQueue.isEmpty()) {
            DTO dto =  priorityQueue.poll();
            k--;
            if(k == 0){
                arr1[0] = dto.i;
                arr1[1] = dto.j;
                return arr1;
            }
        }
        return arr1;
    }
}

class DTO {
    int i;
    int j;
    double value;

}
