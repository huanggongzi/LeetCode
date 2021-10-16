package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/15/23:47
 * @Description:
 */
public class _1015外观数列 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        for (int i = 2; i <= n; i++) {
            sb = miaoshu(sb.toString());
        }
        return sb.toString();
    }


    public static StringBuffer miaoshu(String string) {
        int len = string.length();
        StringBuffer sb = new StringBuffer();
        int left = 0;
        while (left < len) {
            int num = 1;
            while (left < len - 1 && string.charAt(left) == string.charAt(left + 1)) {
                num++;
                left++;
            }
            sb.append(num + "" + string.charAt(left));
            left++;
        }
        return sb;
    }
}
