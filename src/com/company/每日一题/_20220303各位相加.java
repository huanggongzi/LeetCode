package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/03/23:38
 * @Description:
 */
public class _20220303各位相加 {
    public int addDigits(int num) {
        if (String.valueOf(num).length() == 1) {
            return num;
        }
        return addDigits(getNum(num));
    }

    public int getNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        //System.out.println(sum);
        return sum;
    }
}
