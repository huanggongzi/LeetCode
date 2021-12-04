package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/04/23:39
 * @Description:
 */
public class _1204赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNotes = new int[26];
        int[] magazines = new int[26];

        for(int i = 0; i < ransomNote.length(); i++){
            ransomNotes[ransomNote.charAt(i) - 'a']++;
        }

        for(int i = 0; i < magazine.length(); i++){
            magazines[magazine.charAt(i) - 'a']++;
        }

        // magazines 大于 ransomNote
        for(int i = 0; i < 26; i++){
            if(magazines[i] < ransomNotes[i]){
                return false;
            }
        }

        return true;
    }
}
