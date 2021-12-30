package com.company.每日一题;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/30/22:31
 * @Description:
 */
public class _1230一手顺子 {
    public static void main(String[] args) {
        int[] arr = new int[]{53,78,62,108,83,56,66,110,49,104,117,123,86,131,94,107,84,103,42,127,100,50,55,97,81,93,71,45,63,39,91,87,129,126,84,125,73,95,116,47,106,52,121,54,38,68,69,76,89,90,57,67,86,114,64,87,79,92,115,60,51,105,132,101,59,130,44,85,80,82,48,65,128,102,74,61,40,46,98,111,109,119,72,43,112,120,58,113,77,88,41,118,75,85,124,122,96,83,99,70};
        int groupSize = 50;
        System.out.println(isNStraightHand(arr, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(key);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            int value = map.get(key);
            // 代表当前数字已经全部被消费过
            if (value == 0) {
                continue;
            }
            for (int j = 1; j < groupSize; j++) {
                if (map.get(key + j) == null) {
                    return false;
                } else {
                    if (map.get(key + j) >= value) {
                        map.put(key + j, map.get(key + j) - value);
                    } else {
                        return false;
                    }
                }
            }
            map.put(key, 0);
        }

        // 最后检查一遍
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}
