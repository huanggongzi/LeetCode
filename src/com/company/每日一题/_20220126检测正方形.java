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
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10});
        detectSquares.count(new int[]{14, 8});
        detectSquares.add(new int[]{11, 2});
        detectSquares.count(new int[]{11, 10);
    }
}

 class DetectSquares {
    Map<String, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        map.put(point[0] + " " + point[1], map.getOrDefault(point, 0) + 1);
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
                if (map.containsKey(x2 + " " + y2) && map.containsKey(x2 + "" + y1)) {
                    sum = sum + Math.min(count, Math.min(map.get(x2 + " " + y2), map.get(x2 + "" + y1)));
                }
                // 如果向右走
                int x3 = x + len;
                int y3 = y;
                if (map.containsKey(x3 + " " + y3) && map.containsKey(x3 + "" + y1)) {
                    sum = sum + Math.min(count, Math.min(map.get(x3 + " " + y3), map.get(x3 + "" + y1)));
                }
            }
        }
        return sum;
    }
}
