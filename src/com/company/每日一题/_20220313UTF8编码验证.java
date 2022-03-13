package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/13/23:27
 * @Description:
 */
public class _20220313UTF8编码验证 {
    public boolean validUtf8(int[] data) {
        String sb = getString(data);
        String[] str = sb.split(" ");
        int index = 0;
        while (index < str.length) {
            // 判断当前属于及几字节
            String s = str[index];
            if (s.charAt(0) == '0') {
                // 1字节
                index = index + 1;
            } else if (s.charAt(0) == '1' && s.charAt(1) == '1' && s.charAt(2) == '1' && s.charAt(3) == '1' && s.charAt(4) == '0') {
                // 三字节
                int count = 0;
                index++;
                while (index < str.length && str[index].startsWith("10") && count < 3) {
                    count++;
                    index++;
                }
                if (count < 3) {
                    return false;
                }
            } else if (s.charAt(0) == '1' && s.charAt(1) == '1' && s.charAt(2) == '1' && s.charAt(3) == '0') {
                // 二字节
                int count = 0;
                index++;
                while (index < str.length && str[index].startsWith("10") && count < 2) {
                    count++;
                    index++;
                }
                if (count < 2) {
                    return false;
                }
            } else if (s.charAt(0) == '1' && s.charAt(1) == '1' && s.charAt(2) == '0') {
                // 一字节
                int count = 0;
                index++;
                while (index < str.length && str[index].startsWith("10") && count < 1) {
                    count++;
                    index++;
                }
                if (count < 1) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public String getString(int[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(f(data[i]) + " ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String f(int num) {
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        while (sb.length() < 8) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}
