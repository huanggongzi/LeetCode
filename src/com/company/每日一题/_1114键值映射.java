package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/14/23:15
 * @Description:
 */
public class _1114键值映射 {
    class MapSum {
        int pass;
        int end;
        MapSum[] mapSums;
        HashMap<String, Integer> map;

        public MapSum() {
            pass = 0;
            end = 0;
            map = new HashMap<>();
            mapSums = new MapSum[26];
        }

        public void insert(String key, int val) {
            int temp = val;
            if (map.containsKey(key)) {
                val = val - map.get(key);
            }
            map.put(key, temp);
            MapSum curr = this;
            int path = 0;
            char[] ch = key.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                path = ch[i] - 'a';
                if (curr.mapSums[path] == null) {
                    curr.mapSums[path] = new MapSum();
                }
                curr.pass = curr.pass + val;
                curr = curr.mapSums[path];
            }
            curr.pass += val;
        }

        public int sum(String prefix) {
            MapSum curr = this;
            int path = 0;
            char[] ch = prefix.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                path = ch[i] - 'a';
                if (curr.mapSums[path] == null) {
                    return 0;
                }
                curr = curr.mapSums[path];
            }
            return curr.pass;
        }
    }
}
