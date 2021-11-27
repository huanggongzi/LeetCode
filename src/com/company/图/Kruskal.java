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

    public int minCostConnectPoints(int[][] points) {
        Graph graph = new Graph();
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int value = getval(x1, y1, x2, y2);
                addNode(graph, value, i, j);
            }
        }
        Union union = new Union();
        for (Node node : graph.nodes.values()) {
            union.makeSets(node);
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        int sum = 0;
        // 从最小的开始
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            // 看一下是否存在环
            if (!union.isSame(edge.from, edge.to)) {
                sum = sum + edge.weight;
                union.union(edge.from, edge.to);
            }
        }
        return sum;
    }


    public void addNode(Graph graph, int value, int i, int j) {
        int from = i;
        int to = j;
        int weight = value;
        if (!graph.nodes.containsKey(from)) {
            graph.nodes.put(from, new Node(from));
        }
        if (!graph.nodes.containsKey(to)) {
            graph.nodes.put(to, new Node(to));
        }
        Node fromNode = graph.nodes.get(from);
        Node toNode = graph.nodes.get(to);
        Edge edge = new Edge(fromNode, toNode, weight);
        fromNode.out++;
        toNode.in++;
        fromNode.nexts.add(toNode);
        fromNode.edges.add(edge);
        graph.edges.add(edge);

    }

    public int getval(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

/**
 * 并查集
 */
class Union {
    // 当前节点的父节点
    Map<Node, Node> parent;
    // 当前节点所挂的节点数量
    Map<Node, Integer> size;

    // 初始化
    public Union() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    // 赋予初始值
    public void makeSets(Node node) {

        parent.put(node, node);
        size.put(node, 1);

    }

    // 合并
    public void union(Node node1, Node node2) {
        // 找到两个节点的父节点
        Node node1Parent = getParentNode(node1);
        Node node2Parent = getParentNode(node2);
        // 看看是不是一个父亲
        if (node1Parent != node2Parent) {
            // node1、node2父亲的节点数量
            int size1 = size.get(node1Parent);
            int size2 = size.get(node2Parent);
            // 谁的节点多，少的就挂在多的下面，进行合并
            if (size1 >= size2) {
                parent.put(node1Parent, node2Parent);
                size.put(node1Parent, size1 + size2);
                size.remove(node2Parent);
            } else {
                parent.put(node2Parent, node1Parent);
                size.put(node2Parent, size1 + size2);
                size.remove(node2Parent);
            }
        }
    }

    public boolean isSame(Node node1, Node node2) {
        return getParentNode(node1) == getParentNode(node2);
    }

    public Node getParentNode(Node node) {
        // 为了路径压缩
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