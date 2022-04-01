package com.company.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/01/22:34
 * @Description:
 */
public class _20220401二倍数对数组 {

    public static void main(String[] args) {
        canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4});
    }

    public static boolean canReorderDoubled(int[] arr) {
        int num = arr.length / 2;
        Arrays.sort(arr);
        // 正数、负数、零

        // 正数
        Map<Integer, Integer> positiveMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            positiveMap.put(arr[i], positiveMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                listC.add(arr[i]);
            } else if (arr[i] > 0) {
                listA.add(arr[i]);
            } else {
                listB.add(arr[i]);
            }
        }

        // 先从正数开始，正数肯定是偶数
        if (listA.size() % 2 != 0) {
            return false;
        }
        int count = 0;
        int index = 0;
        while (count <= listA.size() / 2) {
            int value1 = positiveMap.get(listA.get(index));
            int value2 = positiveMap.get(2 * listA.get(index));
            if (value1 <= 0) {
                index++;
                continue;
            }
            if (value2 <= 0) {
                return false;
            }
            positiveMap.put(listA.get(index), value1 - 1);
            positiveMap.put(2 * listA.get(index), value2 - 1);
            count++;
            index++;
        }

        // 从负数开始
        if (listB.size() % 2 != 0) {
            return false;
        }
        count = 0;
        index = listB.size() - 1;
        while (count <= listB.size() / 2) {
            int value1 = positiveMap.get(listB.get(index));
            int value2 = positiveMap.get(2 * listB.get(index));
            if (value1 <= 0) {
                index++;
                continue;
            }
            if (value2 <= 0) {
                return false;
            }
            positiveMap.put(listB.get(index), value1 - 1);
            positiveMap.put(2 * listB.get(index), value2 - 1);
            count++;
            index--;
        }

        if (listC.size() % 2 != 0) {
            return false;
        }
        return true;
    }
}
