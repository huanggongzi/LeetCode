package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/29/23:53
 * @Description:
 */
public class _20220329考试的最大困扰度 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getNum(answerKey, k, 'T'), getNum(answerKey, k, 'F'));
    }


    public int getNum(String answerKey, int k, char ch) {
        int size = 0;
        int right = 0;
        int max = 0;
        int left = 0;
        while (right < answerKey.length()) {
            if (answerKey.charAt(right) == ch) {
                size++;
            }
            while (size > k) {
                if (answerKey.charAt(left++) == ch) {
                    size--;
                }
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
