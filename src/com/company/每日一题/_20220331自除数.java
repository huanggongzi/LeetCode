package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/31/23:56
 * @Description:
 */
public class _20220331自除数 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (f(i)) {
                list.add(i);
            }
        }
        return list;
    }


    public boolean f(int i) {
        boolean flag = true;
        int num = i;
        while (i != 0) {
            int n = i % 10;
            if (n == 0 || num % n != 0) {
                flag = false;
                return flag;
            }
            i = i / 10;
        }
        return flag;
    }
}
