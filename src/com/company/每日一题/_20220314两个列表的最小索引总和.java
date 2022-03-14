package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/14/23:54
 * @Description:
 */
public class _20220314两个列表的最小索引总和 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        List<String> list = new ArrayList<>();
        int min = 9999;
        for (int i = 0; i < list1.length; i++) {
            if (map1.get(list1[i]) != null && map2.get(list1[i]) != null) {
                if (map1.get(list1[i]) + map2.get(list1[i]) <= min) {
                    min = map1.get(list1[i]) + map2.get(list1[i]);
                }
            }
        }

        for (int i = 0; i < list1.length; i++) {
            if (map1.get(list1[i]) != null && map2.get(list1[i]) != null) {
                if (map1.get(list1[i]) + map2.get(list1[i]) == min) {
                    list.add(list1[i]);
                }
            }
        }
        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }
}
