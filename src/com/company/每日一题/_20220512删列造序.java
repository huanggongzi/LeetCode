package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/12/23:59
 * @Description:
 */
public class _20220512删列造序 {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) - 'a' < strs[j - 1].charAt(i) - 'a'){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
