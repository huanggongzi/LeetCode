package com.company.每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/12/23:40
 * @Description:
 */
public class _20220312N叉树的后序遍历 {
    public List<Integer> postorder(Node1 root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }

    public void dfs(List<Integer> list, Node1 root) {
        if (root != null) {
            for (Node1 currNode : root.children) {
                dfs(list, currNode);
            }
            list.add(root.val);
        }
    }
}

