package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/11/26/23:41
 * @Description:
 */
public class _1126二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return root;
        }

        if(root.val < val){
            return searchBST(root.right, val);
        }else if(root.val > val){
            return searchBST(root.left, val);
        }else{
            return root;
        }
    }
}
