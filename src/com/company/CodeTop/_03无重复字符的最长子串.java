package com.company.CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/03/23:49
 * @Description:
 */
public class _03无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            max = Math.max(max, i - left + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
