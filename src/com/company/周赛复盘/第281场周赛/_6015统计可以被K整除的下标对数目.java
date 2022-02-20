package com.company.周赛复盘.第281场周赛;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/20/18:17
 * @Description:
 */
public class _6015统计可以被K整除的下标对数目 {
    public long coutPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = gcd(num, k);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        long count = 0;
        for (Integer key1 : map.keySet()) {
            for (Integer key2 : map.keySet()) {
                // 这里需要注意:key1 * key2 会超越int的范围,需要转换为long
                if (key1 <= key2 && (long) key1 * (long) key2 % k == 0) {
                    // 同样,value1 * value2 也会越int的界,需要转换为long
                    long value1 = (long) map.get(key1);
                    long value2 = (long) map.get(key2);
                    if (key1 < key2) {
                        count = count + value1 * value2;
                    } else {
                        count = count + value1 * (value2 - 1) / 2;
                    }
                }
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
