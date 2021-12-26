package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/26/19:49
 * @Description:
 */
public class _1226Bigram分词 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str = text.split(" ");
        if (str.length <= 2) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length - 2; i++) {
            String str1 = str[i];
            String str2 = str[i + 1];
            String str3 = str[i + 2];
            if (str1.equals(first) && str2.equals(second)) {
                list.add(str3);
            }
        }

        String[] target = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
