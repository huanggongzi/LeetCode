package com.company.每日一题;

public class _20220717数组嵌套 {
    public int arrayNesting(int[] nums) {
        int sum = 0;
        boolean[] vis = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum = Math.max(sum, dfs(nums, i, vis));
        }
        return sum;
    }

    public int dfs(int[] nums, int index, boolean[] vis){
        // 当前的数值重复时
        if(vis[index]){
            return 0;
        }

        // 走过了标记一下
        vis[index] = true;

        return dfs(nums, nums[index], vis) + 1;
    }
}
