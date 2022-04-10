package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/10/23:34
 * @Description:
 */
public class _20220410唯一摩尔斯密码词 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] strs = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();

        for(int i = 0; i < words.length; i++){
            String str = "";
            for(int j = 0; j < words[i].length(); j++){
                str = str + strs[words[i].charAt(j) - 'a'];
            }
            if(str != ""){
                set.add(str);
            }
        }
        return set.size();
    }
}
