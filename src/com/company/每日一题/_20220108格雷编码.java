package com.company.每日一题;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/08/15:11
 * @Description:
 */
public class _20220108格雷编码 {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head = head << 1;
        }
        return list;
    }
}
