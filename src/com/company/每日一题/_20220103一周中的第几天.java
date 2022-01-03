package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/03/23:18
 * @Description:
 */
public class _20220103一周中的第几天 {
    public String dayOfTheWeek(int day, int month, int year) {
        // 1970 年 12 月 31 日是星期四
        // 计算和1971年1月1号的天数
        String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 4;
        for (int i = 1971; i < year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                days = days + 366;
            } else {
                days = days + 365;
            }
        }
        // 月份
        for (int i = 1; i < month; i++) {
            days = days + months[i - 1];
        }
        // 大于2的话
        if (month > 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                days++;
            }
        }
        days = days + day;
        return weeks[days % 7];
    }
}
