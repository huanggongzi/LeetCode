package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

public class _20220806数组中的字符串匹配 {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    ret.add(words[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
