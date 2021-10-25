package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 你的名字
 * @Date: 2021/09/12/22:54
 * @Description:
 */
public class _913有效的括号字符串 {
    // git config --global http.sslVerify "false"
    public int numberOfBoomerangs(int[][] points) {
        // 三个点 x y z
        // x 到 y 的距离 = y 到 z 的距离
        // 使用 Hash 保存当前点到别的点的距离
        int sum = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int num = getNum(points[i][0], points[i][1], points[j][0], points[j][1]);
                    if (map.containsKey(num)) {
                        int value = map.get(num);
                        value++;
                        map.put(num, value);
                    } else {
                        map.put(num, 1);
                    }
                }
            }
            for(Integer key :  map.keySet()){
                if(map.get(key) >= 2){
                    sum = sum + (map.get(key) - 1) * map.get(key);
                }
            }
        }
        return sum;

    }

    public int getNum(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
