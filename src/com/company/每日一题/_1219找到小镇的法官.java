package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/19/23:33
 * @Description:
 */
public class _1219找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        // 信任的人
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            list1.add(new ArrayList<>());
        }

        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            list.get(a).add(b);
            list1.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (list.get(i).size() == 0 && list1.get(i).size() == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
