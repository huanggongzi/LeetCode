package com.company.每日一题;

public class _20220801生成每种字符都是奇数个的字符串 {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        // 偶数
        if(n % 2 == 0){
            for(int i = 0; i < n - 1; i++){
                sb.append("a");
            }
            sb.append("b");
        }else{
            for(int i = 0; i < n; i++){
                sb.append("a");
            }
        }
        return sb.toString();
    }
}
