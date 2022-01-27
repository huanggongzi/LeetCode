package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/01/27/22:25
 * @Description:
 */
public class _20220127句子中的有效单词数 {
    public int countValidWords(String sentence) {
        // 获取每一个单词
        String[] strs = sentence.split(" ");
        int count = 0;
        for(int i = 0; i < strs.length; i++){
            if(strs[i] != "" && panDuan(strs[i])){
                count++;
            }
        }
        return count;
    }

    public boolean panDuan(String str){
        int countLink = 0;
        int count1 = 0;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            // 排除数字
            if(chars[i] >= '0' && chars[i] <= '9'){
                return false;
            }else if(chars[i] == '-'){
                if(count1 == 1){
                    return false;
                }
                // 排除 '-'
                if(i == 0 || i == chars.length - 1){
                    return false;
                }
                if(!xiaoZiMu(chars[i - 1])){
                    return false;
                }
                if(!xiaoZiMu(chars[i + 1])){
                    return false;
                }
                count1 = 1;
            }else if(xiaoZiMu(chars[i])){
            }else{
                if(countLink < 1 && i == chars.length - 1){
                    countLink = 1;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean xiaoZiMu(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return true;
        }
        return false;
    }
}
