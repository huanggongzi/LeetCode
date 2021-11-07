package com.company.每日一题;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/08/0:11
 * @Description:
 */
public class _1108猜数字游戏 {
    public String getHint(String secret, String guess) {
        int len = secret.length();
        boolean[] vis = new boolean[len];

        // 公牛的
        int bullsCount = 0;
        for(int i = 0; i < len; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bullsCount++;
                vis[i] = true;
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!vis[i]){
                if(map.containsKey(secret.charAt(i))){
                    int value = map.get(secret.charAt(i));
                    value++;
                    map.put(secret.charAt(i), value);
                }else{
                    map.put(secret.charAt(i), 1);
                }
            }
        }

        // 母牛的
        int cowsCount = 0;
        for(int i = 0; i < len; i++){
            if(!vis[i]){
                if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0){
                    cowsCount++;
                    int value = map.get(guess.charAt(i));
                    value--;
                    map.put(guess.charAt(i), value);
                }
            }
        }

        return bullsCount + "A" + cowsCount + "B";
    }
}
