package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/10/23:51
 * @Description:
 */
public class _20220210最简分数 {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if(n == 1){
            return list;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(!f(i, j)){
                    list.add(j + "/" + i);
                }
            }
        }
        return list;
    }

    public boolean f(int x, int y){
        //System.out.println(x + " " + y);
        for(int i = 2; i <= y; i++){
            if(x % i == 0 && y % i == 0){
                return true;
            }
        }
        return false;
    }
}
