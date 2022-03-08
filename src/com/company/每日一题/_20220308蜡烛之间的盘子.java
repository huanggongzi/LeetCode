package com.company.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/08/23:49
 * @Description:
 */
public class _20220308蜡烛之间的盘子 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] array = new int[queries.length];
        int[] arr = getArray(s);
        // 向左的
        Map<Integer, Integer> map1 = new HashMap<>();
        int index = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                index = i;
            }
            map1.put(i, index);
        }
        // 向右的
        Map<Integer, Integer> map2 = new HashMap<>();
        index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                index = i;
            }
            map2.put(i, index);
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int leftIndex = map1.get(left);
            int rightIndex = map2.get(right);
            if (leftIndex < right && rightIndex > left) {
                array[i] = arr[rightIndex] - arr[leftIndex];
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    // 前缀和
    public int[] getArray(String s) {
        int[] arr = new int[s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            arr[i] = sum;
        }
        return arr;
    }
}
