package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/09/23:58
 * @Description:
 */
public class _20220509增减字符串匹配 {
    public int[] diStringMatch(String s) {
        int[] array = new int[s.length() + 1];
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                array[i] = num++;
                if(i == s.length() - 1){
                    array[s.length()] = num++;
                }
            }
        }

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == 'D'){
                if(i == s.length() - 1){
                    array[s.length()] = num++;
                }
                array[i] = num++;
            }
        }

        return array;
    }
}
