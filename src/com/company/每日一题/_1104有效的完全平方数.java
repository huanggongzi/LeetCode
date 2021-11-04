package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/04/23:49
 * @Description:
 */
public class _1104有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        double ans = num;
        double dir = num;
        while(ans * ans - dir >= 1e-6){
            ans = ans / 2 + dir / (2 * ans);
        }
        int x = (int)ans;
        return x * x == num;
    }
}
