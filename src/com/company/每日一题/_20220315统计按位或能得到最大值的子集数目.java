package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/15/23:53
 * @Description:
 */
public class _20220315统计按位或能得到最大值的子集数目 {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(list, path, 0, nums);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list2 = list.get(i);
            if (list2.size() != 0) {
                int num = list2.get(0);
                for (int j = 1; j < list2.size(); j++) {
                    num = num | list2.get(j);
                }
                max = Math.max(max, num);
            }
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list2 = list.get(i);
            if (list2.size() != 0) {
                int num = list2.get(0);
                for (int j = 1; j < list2.size(); j++) {
                    num = num | list2.get(j);
                }
                if (num == max) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> list, List<Integer> path, int index, int[] nums) {
        if (index == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        // list.add(new ArrayList<>(path));
        // 选中当前的
        path.add(nums[index]);
        dfs(list, path, index + 1, nums);
        path.remove(path.size() - 1);
        // 不选当前的
        dfs(list, path, index + 1, nums);
    }
}
