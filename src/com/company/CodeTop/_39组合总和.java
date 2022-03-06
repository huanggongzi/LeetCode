package com.company.CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/06/1:34
 * @Description:
 */
public class _39组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(list, candidates, path, target, 0, 0);
        return list;
    }

    public void dfs(List<List<Integer>> list, int[] candidates, List<Integer> path, int target, int sum, int index) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            list.add(new ArrayList<>(path));
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(list, candidates, path, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }

    }
}
