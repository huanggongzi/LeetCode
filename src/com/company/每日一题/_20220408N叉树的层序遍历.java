package com.company.每日一题;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/04/08/23:57
 * @Description:
 */
public class _20220408N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return new ArrayList<>();
        }
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            List<Integer> path = new ArrayList<>();
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                path.add(node.val);
                if(node.children != null){
                    for(Node ch : node.children){
                        queue.add(ch);
                    }
                }
            }
            list.add(path);
        }
        return list;
    }
}
