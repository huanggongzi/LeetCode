package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/24/21:13
 * @Description:
 */
public class _1024大礼包 {
    Map<List<Integer>, Integer> map = new HashMap<>();
    int n = 0;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> filterSpecial = new ArrayList<List<Integer>>();
        // 去掉
        for (int i = 0; i < special.size(); i++) {
            int len = special.get(i).size();
            boolean sumNum = true;
            int sumValue = 0;
            for (int j = 0; j < len - 1; j++) {
                if (special.get(i).get(j) > needs.get(j)) {
                    sumNum = false;
                    j = special.get(i).size();
                }
                sumValue += special.get(i).get(j) * price.get(j);
            }
            if (sumNum && sumValue > special.get(i).get(len - 1)) {
                filterSpecial.add(special.get(i));
            }
        }
        return dfs(needs, price, filterSpecial);
    }

    private int dfs(List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        // 不使用大礼包的前提下
        int ans = 0;
        int n = needs.size();
        for (int i = 0; i < n; i++) {
            ans += needs.get(i) * price.get(i);
        }
        // 使用大礼包的前提下 是否超出我们的使用限制
        for (List<Integer> specialList : special) {
            List<Integer> curr = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (specialList.get(i) > needs.get(i)) {
                    flag = false;
                    break;
                }
                curr.add(i, needs.get(i) - specialList.get(i));
            }
            // 如果没有超过的话
            if (flag) {
                ans = Math.min(ans, specialList.get(n) + dfs(curr, price, special));
            }
        }
        map.put(needs, ans);
        return ans;
    }

}
