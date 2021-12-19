package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/17/23:40
 * @Description:
 */
public class _1217换酒问题 {
    public int numWaterBottles(int numBottles, int numExchange) {
        // 能喝到的酒
        int num = numBottles;
        // 空瓶子
        int sum = numBottles;

        // 换不起酒
        while (sum >= numExchange) {
            // 换的酒数
            int wine = sum / numExchange;
            // 剩余的瓶子
            int bottles = sum % numExchange;
            // 先喝酒
            num = num + wine;
            sum = bottles + wine;
        }

        return num;
    }
}
