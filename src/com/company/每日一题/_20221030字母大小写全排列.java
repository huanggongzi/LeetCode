package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

public class _20221030字母大小写全排列 {
    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        dfs(n, 0, list, sb, s);
        return list;
    }


    public static void dfs(int n, int index, List<String> list, StringBuffer sb, String s) {
        // 到头了
        if (index == n) {
            list.add(new String(sb.toString()));
            return;
        }

        char ch = s.charAt(index);

        if (isZiMu(ch)) {
            // 不变
            dfs(n, index + 1, list, sb.append(ch), s);
            sb.deleteCharAt(sb.length() - 1);

            // 变
            dfs(n, index + 1, list, sb.append(transform(ch)), s);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            dfs(n, index + 1, list, sb.append(ch), s);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static boolean isZiMu(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }

    public static char transform(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32);
        }

        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        }

        return 'a';
    }
}
