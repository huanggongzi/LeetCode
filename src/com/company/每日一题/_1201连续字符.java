package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/01/23:00
 * @Description:
 */
public class _1201连续字符 {
    public int maxPower(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            while(right < s.length() && s.charAt(left) == s.charAt(right)){
                right++;
            }
            max = Math.max(max, right - left);
            left = right;
        }
        return max;
    }
}
