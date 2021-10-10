package com.company.每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/30/0:56
 * @Description:
 */
public class _930矩形面积 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 不相交
        int x1Max = Math.max(ax1, ax2);
        int x1Min = Math.min(ax1, ax2);
        int y1Max = Math.max(ay1, ay2);
        int y1Min = Math.min(ay1, ay2);

        int x2Max = Math.max(bx1, bx2);
        int x2Min = Math.min(bx1, bx2);
        int y2Max = Math.max(by1, by2);
        int y2Min = Math.min(by1, by2);

        List<Integer> listx = new ArrayList<Integer>() {{
            add(ax1);
            add(ax2);
            add(bx1);
            add(bx2);
        }};

        int sum1 = (x1Max - x1Min) * (y1Max - y1Min);
        int sum2 = (x2Max - x2Min) * (y2Max - y2Min);
        List<Integer> listy = new ArrayList<Integer>() {{
            add(ay1);
            add(ay2);
            add(by1);
            add(by2);
        }};

        Collections.sort(listx);
        Collections.sort(listy);
        int sum = 0;
        if (x1Min >= x2Max) {
            sum = 0;
        } else if (x2Min >= x1Max) {
            sum = 0;
        } else if (y1Min >= y2Max) {
            sum = 0;
        } else if (y2Min >= y1Max) {
            sum = 0;
        } else {
            sum = (listx.get(2) - listx.get(1)) * (listy.get(2) - listy.get(1));
        }

        return sum1 + sum2 - sum;

    }
}
