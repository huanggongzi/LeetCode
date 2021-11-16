package com.company.practise;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/16/22:20
 * @Description:
 */
public class _91解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }

    // 递归写一版
    public static int numDecodings(String s) {
        if (s.length() <= 1) {
            return Integer.valueOf(s) == 0 ? 0 : 1;
        }
        return dfs(s.substring(0, 1), s, 1) + dfs(s.substring(0, 2), s, 2);
    }


    public static int dfs(String target, String s, int index) {
        if (isInt(target) || Integer.valueOf(target) > 26 || Integer.valueOf(target) < 1 || index > s.length()) {
            return 0;
        }
        // 如果能来到最后，说明这个可以到达
        if (s.length() == index) {
            return 1;
        }

        int res = 0;

        // 使用一个字母
        res = res + dfs(s.substring(index, index + 1), s, index + 1);

        // 使用两个字母
        if (index + 2 <= s.length()) {
            res = res + dfs(s.substring(index, index + 2), s, index + 2);
        }
        return res;
    }

    public static boolean isInt(String str) {
        if (str.charAt(0) == '0') {
            return true;
        }
        return false;
    }
}
