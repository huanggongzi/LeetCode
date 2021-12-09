package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/10/0:49
 * @Description:
 */
public class _1210最短补全词 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = new int[26];
        int minLen = Integer.MAX_VALUE;
        String targetString = "";
        for (int i = 0; i < licensePlate.length(); i++) {
            if (licensePlate.charAt(i) >= 'a' && licensePlate.charAt(i) <= 'z') {
                target[licensePlate.charAt(i) - 'a']++;
            } else if (licensePlate.charAt(i) >= 'A' && licensePlate.charAt(i) <= 'Z') {
                target[licensePlate.charAt(i) - 'A']++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (check(target, word)) {
                if (word.length() < minLen) {
                    minLen = word.length();
                    targetString = word;
                }
            }
        }

        return targetString;
    }


    public boolean check(int[] target, String word) {
        int[] wordArr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                wordArr[word.charAt(i) - 'a']++;
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                wordArr[word.charAt(i) - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (wordArr[i] < target[i]) {
                return false;
            }
        }

        return true;
    }
}
