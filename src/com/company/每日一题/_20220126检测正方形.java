package com.company.每日一题;


import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/26/23:19
 * @Description:
 */
public class _20220126检测正方形 {
    public static void main(String[] args) {
        _20220126检测正方形 p = new _20220126检测正方形();
        p.Test();
    }

    public void Test() {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{419,351});
        detectSquares.add(new int[]{798,351});
        detectSquares.add(new int[]{798,730});
        detectSquares.count(new int[]{419,730});
    }
}

class DetectSquares {
    Map<String, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        String s = point[0] + " " + point[1];
        map.put(s, map.getOrDefault(s, 0) + 1);
    }

    public int count(int[] point) {
        int sum = 0;
        int x = point[0];
        int y = point[1];
        for (String key : map.keySet()) {
            // 寻找 x 一样的
            String[] strs = key.split(" ");
            int count = map.get(key);
            if (Integer.valueOf(strs[0]) == x) {
                // 寻找 y 一样的
                int y1 = Integer.valueOf(strs[1]);
                int len = Math.abs(y - y1);
                // 如果向左走，两个点分别为
                int x2 = x - len;
                int y2 = y;
                String s1 = x2 + " " + y2;
                String s2 = x2 + " " + y1;
                if (map.containsKey(s1) && map.containsKey(s2)) {
                    sum = sum + Math.max(count, Math.max(map.get(s1), map.get(s2)));
                }
                // 如果向右走
                int x3 = x + len;
                int y3 = y;
                s1 = x3 + " " + y3;
                s2 = x3 + "" + y1;
                if (map.containsKey(s1) && map.containsKey(s2)) {
                    sum = sum + Math.max(count, Math.max(map.get(s1), map.get(s2)));
                }
            }
        }
        return sum;
    }
}
