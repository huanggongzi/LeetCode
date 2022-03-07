package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/06/23:27
 * @Description:
 */
public class _20220306适合打劫银行的日子 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        boolean[] increase = new boolean[security.length];
        boolean[] decrease = new boolean[security.length];

        // 先是递增区间
        int count = 0;
        for (int i = 0; i < security.length; i++) {
            if (i == 0) {
                if (time == 0) {
                    increase[i] = true;
                }
            } else if (security[i] <= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
            if (count >= time) {
                increase[i] = true;
            }
        }

        count = 0;
        // 递减区间
        for (int i = security.length - 1; i >= 0; i--) {
            if (i == security.length - 1) {
                if (time == 0) {
                    decrease[i] = true;
                }
            } else if (security[i] <= security[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            if (count >= time) {
                decrease[i] = true;
            }
        }
        //System.out.println(increase[4] + " " + decrease[4]);
        for (int i = 0; i < security.length; i++) {
            if (increase[i] && decrease[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
