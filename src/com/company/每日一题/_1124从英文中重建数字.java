package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/24/22:58
 * @Description:
 */
public class _1124从英文中重建数字 {
    List<Integer> list = new ArrayList<>();

    public String originalDigits(String s) {
        Map<Character, Integer> map = getMap(s);
        // 排除暴力匹配
        int zero = map.getOrDefault('z', 0);
        int two = map.getOrDefault('w', 0);
        int four = map.getOrDefault('u', 0);
        int six = map.getOrDefault('x', 0);
        int eight = map.getOrDefault('g', 0);
        int three = map.getOrDefault('t', 0) - two - eight;
        int seven = map.getOrDefault('s', 0) - six;
        int one = map.getOrDefault('o', 0) - zero - two - four;
        int five = map.getOrDefault('v', 0) - seven;
        int nine = map.getOrDefault('i', 0) - five - six - eight;
        getTarget(zero, one, two, three, four, five, six, seven, eight, nine);
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i); j++) {
                str = str + i;
            }
        }
        return str;

    }


    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    public void getTarget(int zero, int one, int two, int three, int four, int five, int six, int seven, int eight, int nine) {
        list.add(zero);
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
        list.add(six);
        list.add(seven);
        list.add(eight);
        list.add(nine);
    }
}
