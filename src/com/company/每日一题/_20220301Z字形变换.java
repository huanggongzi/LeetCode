package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/01/23:51
 * @Description:
 */
public class _20220301Z字形变换 {
    public String convert(String s, int numRows) {
        // 一个循环多少
        int value = numRows + (numRows - 2);
        if(numRows == 1){
            return s;
        }
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            int index = i;
            if(i == 0 || i == numRows - 1){
                while(index < len){
                    sb.append(s.charAt(index));
                    index = index + value;
                }
            }else{
                while(index < len){
                    sb.append(s.charAt(index));
                    if(index + 2 * numRows -  2 * (i + 1) < len){
                        sb.append(s.charAt(index + 2 * numRows -  2 * (i + 1)));
                    }
                    index = index + value;
                }
            }
        }
        return sb.toString();
    }
}
