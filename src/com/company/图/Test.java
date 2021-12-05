package com.company.图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/12/05/12:02
 * @Description:
 */
public class Test {
    String s1;
    String s2;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuffer sb = new StringBuffer();
        dfs(root, startValue, sb);
        StringBuffer stringBuffer = new StringBuffer();
        dfs1(root, destValue, stringBuffer);
        System.out.println(s1);
        System.out.println(s2);
        return s1;
    }


    public void dfs(TreeNode root, int startValue, StringBuffer sb) {
        if (root == null) {
            return;
        }
        if (root.val == startValue) {
            s1 = sb.toString();
            return;
        }
        dfs(root, startValue, sb.append("L"));
        sb.deleteCharAt(sb.length() - 1);
        dfs(root.right, startValue, sb.append("R"));
        sb.deleteCharAt(sb.length() - 1);
    }

    public void dfs1(TreeNode root, int destValue, StringBuffer sb) {
        if (root == null) {
            return;
        }
        if (root.val == destValue) {
            s2 = sb.toString();
            return;
        }
        dfs1(root, destValue, sb.append("L"));
        sb.deleteCharAt(sb.length() - 1);
        dfs1(root.right, destValue, sb.append("R"));
        sb.deleteCharAt(sb.length() - 1);
    }

//    给定 a，b 两个数组。
//    从a里头取出数x，每次只能从头或者尾部取，然后接着从b里头取数，第i次取第i-1下标的b中元素，
//    每次取完之后算出一个值：c = x *b[i-1],
//    最后要把所有a中的数都取完了，求所有取法中，c求和后的最大值。

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(100);
        int[] arr = new int[]{2, 1};
    }

    public static int dfs(LinkedList<Integer> list, int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        // 如果我当前取首部
        int first = list.removeFirst();
        int firstSum = dfs(list, arr, index + 1) + first * arr[index];
        list.addFirst(first);

        // 如果我当前取尾部
        int finaly = list.removeLast();
        int finalySum = dfs(list, arr, index + 1) + finaly * arr[index];
        list.addLast(finaly);
        return Math.max(finalySum, firstSum);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}