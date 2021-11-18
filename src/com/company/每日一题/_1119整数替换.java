package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/19/0:44
 * @Description:
 */
public class _1119整数替换 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n, map);
    }


    public int dfs(int n, HashMap<Integer, Integer> map) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = 0;
        if (n % 2 == 0) {
            res = dfs(n / 2, map) + 1;
        } else if (n % 2 == 1) {
            res = Math.min(dfs(n + 1, map), dfs(n - 1, map)) + 1;
        }
        map.put(n, res);
        return res;
    }
}
