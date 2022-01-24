package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/25/0:42
 * @Description:
 */
public class _20220125比赛中的配对次数 {
    public int numberOfMatches(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return dfs(n / 2) + (n / 2);
        } else {
            return dfs((n - 1) / 2 + 1) + (n - 1) / 2;
        }
    }
}
