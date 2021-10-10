package com.company.图;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/10/17:07
 * @Description: 最小生成树
 */
public class Kruskal {

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskalMST(Graph graph) {
        Union union = new Union();
        union.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> set = new HashSet<>();
        // 从最小的开始
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            // 看一下是否存在环
            if (!union.isSame(edge.from, edge.to)) {
                set.add(edge);
                union.union(edge.from, edge.to);
            }
        }
        return set;
    }
}

/**
 * 并查集：合并
 */
class Union {
    // 父亲的节点
    Map<Node, Node> parent;
    // 当前节点所挂的节点
    Map<Node, Integer> size;

    public Union() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    public void makeSets(Collection<Node> list) {
        for (Node node : list) {
            parent.put(node, node);
            size.put(node, 1);
        }
    }

    // 合并
    public void union(Node node1, Node node2) {
        if (!isSame(node1, node2)) {
            int size1 = size.get(node1);
            int size2 = size.get(node2);
            if (size1 >= size2) {
                // 将size2挂在size1的下面
                parent.put(parentNode(node2), node1);
                size.put(node1, size1 + size2);
                size.remove(node2);
            } else {
                parent.put(parentNode(node1), node2);
                size.put(node2, size1 + size2);
                size.remove(node1);
            }
        }
    }

    public boolean isSame(Node node1, Node node2) {
        return parentNode(node1) == parentNode(node2);
    }

    public Node parentNode(Node node) {
        Stack<Node> stack = new Stack<>();
        while (parent.get(node) != node) {
            stack.add(node);
            node = parent.get(node);
        }
        while (!stack.isEmpty()) {
            parent.put(stack.pop(), node);
        }
        return node;
    }
}