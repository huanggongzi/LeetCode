package com.company.每日一题;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/02/23:12
 * @Description:
 */
public class _1202相对名次 {
    public String[] findRelativeRanks(int[] score) {
        int[] newArr = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            newArr[i] = score[i];
        }
        Arrays.sort(newArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 1;
        for (int i = newArr.length - 1; i >= 0; i--) {
            map.put(newArr[i], num++);
        }

        String[] str = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            if (map.get(score[i]) == 1) {
                str[i] = "Gold Medal";
            } else if (map.get(score[i]) == 2) {
                str[i] = "Silver Medal";
            } else if (map.get(score[i]) == 3) {
                str[i] = "Bronze Medal";
            } else {
                str[i] = "" + map.get(score[i]);
            }
        }
        return str;
    }
}
