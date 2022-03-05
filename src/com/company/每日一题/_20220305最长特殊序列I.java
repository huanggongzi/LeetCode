package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/05/23:47
 * @Description:
 */
public class _20220305最长特殊序列I {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        int len1 = a.length();
        int len2 = b.length();
        return len1 >= len2 ? len1 : len2;

    }
}
