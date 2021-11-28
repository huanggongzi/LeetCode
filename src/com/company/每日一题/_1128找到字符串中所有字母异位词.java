package com.company.每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/28/23:28
 * @Description:
 */
public class _1128找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < p.length(); i++){
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sCount, pCount)){
            list.add(0);
        }

        for(int i = 0; i < s.length() - len; i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + len) - 'a']++;

            if(Arrays.equals(sCount, pCount)){
                list.add(i + 1);
            }
        }

        return list;
    }
}
