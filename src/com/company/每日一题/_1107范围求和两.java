package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/07/20:47
 * @Description:
 */
public class _1107范围求和两 {
    public int maxCount(int m, int n, int[][] ops) {
        int X1min = Integer.MAX_VALUE;
        int X2min = Integer.MAX_VALUE;
        if(ops.length == 0){
            return m * n;
        }
        for(int i = 0; i < ops.length; i++){
            X1min = Math.min(X1min, ops[i][0]);
            X2min = Math.min(X2min, ops[i][1]);
        }
        return X1min * X2min;
    }
}
