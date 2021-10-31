package com.company.每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/31/15:52
 * @Description:
 */
public class _1031键盘行 {
    static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('q', 1);
        map.put('w', 1);
        map.put('e', 1);
        map.put('r', 1);
        map.put('t', 1);
        map.put('y', 1);
        map.put('u', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('p', 1);
        map.put('a', 2);
        map.put('s', 2);
        map.put('d', 2);
        map.put('f', 2);
        map.put('g', 2);
        map.put('h', 2);
        map.put('j', 2);
        map.put('k', 2);
        map.put('l', 2);
        map.put('z', 3);
        map.put('x', 3);
        map.put('c', 3);
        map.put('v', 3);
        map.put('b', 3);
        map.put('n', 3);
        map.put('m', 3);
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            char[] str = words[i].toCharArray();
            if(str[i] >= 'A' && str[i] <= 'Z'){
                str[i] = (char) (str[i] + 32);
            }
            int value = map.get(str[0]);
            boolean flag = true;
            for(int j = 1; j < str.length; j++){
                if(map.get(str[j]) != value){
                    flag = false;
                }
            }
            if(flag){
                list.add(words[i]);
            }
        }
        String[] result = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
