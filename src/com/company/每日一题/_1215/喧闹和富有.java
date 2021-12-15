package com.company.每日一题._1215;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/15/23:46
 * @Description:
 */
public class 喧闹和富有 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] answer = new int[quiet.length];
        for(int i = 0; i < answer.length; i++){
            answer[i] = i;
        }
        // 建图
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 入度
        int[] ru = new int[quiet.length + 1];
        // 赋予初值
        for(int i = 0; i <= quiet.length; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i = 0; i < richer.length; i++){
            int from = richer[i][0];
            int to = richer[i][1];
            List<Integer> path = map.get(from);
            path.add(to);
            ru[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i <= quiet.length; i++){
            if(ru[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int value = queue.poll();
            for(Integer key : map.get(value)){
                ru[key]--;
                if(quiet[answer[key]] > quiet[answer[value]]){
                    // System.out.println(value + "----");
                    answer[key] = answer[value];
                }
                if(ru[key] == 0){
                    queue.add(key);
                }
            }
        }

        return answer;
    }
}
