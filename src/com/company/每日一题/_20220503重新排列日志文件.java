package com.company.每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/03/17:41
 * @Description:
 */
public class _20220503重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < logs.length; i++) {
            if (getNumbersLog(logs[i])) {
                numbers.add(logs[i]);
            } else {
                letters.add(logs[i]);
            }
        }

        Collections.sort(letters, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ");
                int index2 = o2.indexOf(" ");
                String l1 = o1.substring(index1 + 1);
                String l2 = o2.substring(index2 + 1);

                if (l1.equals(l2)) {
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                } else {
                    return l1.compareTo(l2);
                }
            }
        });
        String[] result = new String[logs.length];
        int num = 0;
        for (String s : letters) {
            result[num++] = s;
        }
        for (String s : numbers) {
            result[num++] = s;
        }
        return result;
    }


    public boolean getNumbersLog(String str) {
        String[] strs = str.split(" ");
        boolean flag = true;
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) < '0' || strs[i].charAt(j) > '9') {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
