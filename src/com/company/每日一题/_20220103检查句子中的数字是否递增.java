package com.company.每日一题;

public class _20220103检查句子中的数字是否递增 {
    public boolean areNumbersAscending(String s) {
        String[] str = s.split(" ");
        int min = -1;
        for (int i = 0; i < str.length; i++) {
            // 如果是数字的话，转成数字
            if (isNum(str[i])) {
                int num = Integer.valueOf(str[i]);
                if (num <= min) {
                    return false;
                }
                min = num;
            }
        }
        return true;
    }

    public boolean isNum(String str) {
        // 依次判断每个都是0~9之间
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
