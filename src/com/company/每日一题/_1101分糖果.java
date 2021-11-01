package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/01/22:14
 * @Description:
 */
public class _1101分糖果 {
    public int distributeCandies(int[] candyType) {
        int num = candyType.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candyType.length; i++) {
            if (map.containsKey(candyType[i])) {
                int value = map.get(candyType[i]);
                map.put(candyType[i], ++value);
            } else {
                map.put(candyType[i], 1);
            }
        }
        int size = map.size();
        if (num >= size) {
            return size;
        } else {
            return num;
        }
    }
}
