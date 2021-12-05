package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/06/0:35
 * @Description:
 */
public class _1206截断句子 {
    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str[0]);
        for (int i = 1; i < k; i++) {
            stringBuffer.append(" " + str[i]);
        }
        return stringBuffer.toString();
    }
}
