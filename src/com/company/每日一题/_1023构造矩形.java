package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/23/23:40
 * @Description:
 */
public class _1023构造矩形 {
    public int[] constructRectangle(int area) {
        // 长 >= 宽
        int num = (int) Math.sqrt(area);
        int W = num;
        int L = num;
        while (W <= L) {
            if (W * L == area) {
                return new int[]{W, L};
            } else if (W * L < area) {
                L++;
            } else if (W * L > area) {
                W--;
            }
        }
        return new int[]{0,0};
    }
}
