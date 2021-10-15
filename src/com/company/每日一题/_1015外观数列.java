package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/15/23:47
 * @Description:
 */
public class _1015外观数列 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }
}
