package com.company.图;

import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/27/0:37
 * @Description:
 */
public class GraphGenerator {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        Graph graph = createGraph(arr);
        // 从2开始的边有哪些
        List<Edge> edgeList = graph.nodes.get(2).edges;
        for (Edge edge : edgeList) {
            System.out.println("从" + edge.from.value + "---->" + edge.to.value + "权值为" + edge.weight);
        }
    }

    /**
     * [0,1,8]
     * [1,4,5]
     * [2,3,4]
     * [3,4,1]
     *
     * @param matrix
     * @return Graph
     */
    public static Graph createGraph1(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];
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
        return graph;
    }

    public static Graph createGraph(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(fromNode, toNode, 0);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

    public static Graph createGraph(int[][] matrix) {
        // 初始化一个图
        Graph graph = new Graph();

        for (int[] arr : matrix) {
            // 来的点
            int from = arr[0];
            // 去的点
            int to = arr[1];
            // 权重
            int value = arr[2];

            // 生成相对应的点
            Node fromNode = new Node(from);
            Node toNode = new Node(to);

            // 查看当前有没有这个点的信息
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, fromNode);
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, toNode);
            }

            // 生成一个边
            Edge edge = new Edge(fromNode, toNode, value);

            // 点里面加入边
            graph.nodes.get(from).edges.add(edge);

            //  点里面加入下一个点
            graph.nodes.get(from).nexts.add(toNode);

            // 点里面加入入度和出度
            graph.nodes.get(from).out++;
            graph.nodes.get(to).in++;

            // 图里面加入边
            graph.edges.add(edge);

        }
        return graph;
    }
}
