package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/07/23:43
 * @Description:
 */
public class _20220307七进制数 {
    public String convertToBase7(int num) {
        StringBuffer sb = new StringBuffer();
        if (num == 0) {
            sb.append("0");
            return sb.toString();
        }
        boolean flag = false;
        if (num < 0) {
            num = -num;
            flag = true;
        }
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        return flag == false ? sb.reverse().toString() : "-" + sb.reverse().toString();
    }
}
