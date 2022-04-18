package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/18/23:44
 * @Description:
 */
public class _20220418字典序排数 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return list;
    }

    public void dfs(int curr, int n) {
        if (curr > n) {
            return;
        }
        list.add(curr);
        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, n);
        }
    }
}
