package com.company.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/18/23:42
 * @Description:
 */
public class _20220218找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        int len = edges.length + 2;
        int[] arr = new int[len];
        for (int[] edge : edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] == len - 2) {
                return i;
            }
        }
        return 0;
    }
}
