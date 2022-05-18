package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/05/17/23:42
 * @Description:
 */
public class _20220517验证外星语词典 {
    HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        int index = order.length() - 1;
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), index--);
        }
        for(int i = 0; i < words.length - 1; i++){
            if(!f(words[i], words[i + 1])){
                return false;
            }
        }
        return true;
    }


    public boolean f(String str1, String str2){
        if(str1.equals(str2)){
            return true;
        }
        int left = 0;
        int right = 0;
        while(left < str1.length() && right < str2.length()){
            if(map.get(str1.charAt(left)) < map.get(str2.charAt(right))){
                return false;
            }else if(map.get(str1.charAt(left)) == map.get(str2.charAt(right))){
                left++;
                right++;
            }else if(map.get(str1.charAt(left)) > map.get(str2.charAt(right))){
                return true;
            }
        }
        if(left < str1.length()){
            return false;
        }
        return true;
    }
}
