package com.company.CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/06/1:00
 * @Description:
 */
public class _46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(list, nums, path, 0, vis);
        return list;
    }

    public void dfs(List<List<Integer>> list, int[] nums, List<Integer> path, int index, boolean[] vis) {
        if (index == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                path.add(nums[i]);
                dfs(list, nums, path, index + 1, vis);
                vis[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
