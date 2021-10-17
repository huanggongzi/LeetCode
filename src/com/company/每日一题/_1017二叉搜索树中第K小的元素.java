package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/17/23:52
 * @Description:
 */
public class _1017二叉搜索树中第K小的元素 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        zhongxu(root, list);
        return list.get(k - 1);
    }

    public void zhongxu(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        zhongxu(root.left, list);
        list.add(root.val);
        zhongxu(root.right, list);
    }
}
