package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/12/23:54
 * @Description:
 */
public class _20220412写字符串需要的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        int count = 1;
        int sum = 100;
        for(int i = 0; i < s.length(); i++){
            int num = widths[s.charAt(i) - 'a'];
            if(sum < num){
                count++;
                sum = 100;
            }
            sum = sum - num;
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = 100 - sum;
        return result;
    }
}
