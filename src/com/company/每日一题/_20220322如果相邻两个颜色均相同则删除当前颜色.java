package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/22/23:56
 * @Description:
 */
public class _20220322如果相邻两个颜色均相同则删除当前颜色 {
    public boolean winnerOfGame(String colors) {
        // A 和 B的删除完全没有联系
        int countA = 0;
        int countB = 0;
        if (colors.length() <= 2) {
            return false;
        }

        int left = 0;
        int right = 0;
        while (right < colors.length()) {
            while (right < colors.length() && colors.charAt(right) == colors.charAt(left)) {
                right++;
            }
            int num = right - left;
            if (num >= 3) {
                if (colors.charAt(left) == 'A') {
                    countA = countA + num - 2;
                } else {
                    countB = countB + num - 2;
                }
            }
            left = right;
        }
        // System.out.println(countA + " " + countB);
        return countA > countB ? true : false;
    }
}
