package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/13/23:33
 * @Description:
 */
public class _20220213气球的最大数量 {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = text.toCharArray();
        for(int i = 0; i < ch.length; i++){
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }
        //
        int p1 = map.getOrDefault('b', 0);
        int p2 = map.getOrDefault('a', 0);
        int p3 = map.getOrDefault('l', 0) / 2;
        int p4 = map.getOrDefault('o', 0) / 2;
        int p5 = map.getOrDefault('n', 0);
        return Math.min(p5, Math.min(Math.min(p1, p2), Math.min(p3, p4)));

    }
}
