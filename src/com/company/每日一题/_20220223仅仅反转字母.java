package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/02/23/22:32
 * @Description:
 */
public class _20220223仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while(left < right){
            while(left < right && !f(charArray[left])){
                left++;
            }
            while(left < right && !f(charArray[right])){
                right--;
            }

            char temp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = temp;
        }
        return String.valueOf(charArray);
    }


    public boolean f(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return true;
        }
        if(ch >= 'A' && ch <= 'Z'){
            return true;
        }
        return false;
    }
}
