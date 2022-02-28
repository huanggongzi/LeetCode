package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/28/23:46
 * @Description:
 */
public class _20220228最多可达成的换楼请求数目 {
    int[] delta;
    int ans = 0, cnt = 0, zero, n;

    public int maximumRequests(int n, int[][] requests) {
        delta = new int[n];
        zero = n;
        this.n = n;
        dfs(requests, 0);
        return ans;
    }

    public void dfs(int[][] requests, int pos) {
        if (pos == requests.length) {
            if (zero == n) {
                ans = Math.max(ans, cnt);
            }
            return;
        }

        // 不选 requests[pos]
        dfs(requests, pos + 1);

        // 选 requests[pos]
        int z = zero;
        ++cnt;
        int[] r = requests[pos];
        int x = r[0], y = r[1];
        zero -= delta[x] == 0 ? 1 : 0;
        --delta[x];
        zero += delta[x] == 0 ? 1 : 0;
        zero -= delta[y] == 0 ? 1 : 0;
        ++delta[y];
        zero += delta[y] == 0 ? 1 : 0;
        dfs(requests, pos + 1);
        --delta[y];
        ++delta[x];
        --cnt;
        zero = z;
    }
}
