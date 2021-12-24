package com.company.每日一题;

import javax.swing.event.AncestorEvent;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/23/22:23
 * @Description:
 */
public class _1223最长重复子串 {
    private static final long PRIME = 31;

    public String longestDupSubstring(String s) {
        String ans = "";
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            // mid 是要找的长度
            int mid = (l + r + 1) / 2;
            // 看是否能找到这么长的重复子串
            String x = find(s, mid);
            if (!x.equals("")) {
                // 找到了再看更长的子串，更短的不用看了
                l = mid + 1;
                ans = x;
            } else {
                // 没找到再看更短的子串
                r = mid - 1;
            }
        }
        return ans;
    }

    private String find(String s, int len) {
        String ans = "";
        Set<Long> set = new HashSet<>();
        long hash = 0;
        long power = 1;
        // 先计算前len个字符组成的子串的hash
        // 与java的String的hashCode()方法一样
        for (int i = 0; i < len; i++) {
            hash = hash * PRIME + s.charAt(i);
            power *= PRIME;
        }

        set.add(hash);

        // 滑动窗口向后移，每次移动要把移出窗口的减去，再加上新的
        for (int i = len; i < s.length(); i++) {
            hash = hash * PRIME + s.charAt(i) - power * s.charAt(i - len);
            // 如果包含相同的hash说明之前可能出现过相同的子串
            // 再检测一下从头查找相同的子串，它的位置不是当前 i 的位置，说明确实是相同的子串
            // 否则，可能是因为hash冲突导致的误判
            // 针对本题，不加indexOf这个判断
            // 也可以过，是因为没有出现这样的用例
            // 但是，为了逻辑更严谨，还是应该加上这个判断
            if (set.contains(hash) && s.indexOf(ans = s.substring(i - len + 1, i + 1)) != i) {
                return ans;
            }
            set.add(hash);
        }

        return ans;
    }
}
