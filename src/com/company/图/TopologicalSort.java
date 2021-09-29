package com.company.图;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/29/0:31
 * @Description:
 */
public class TopologicalSort {
    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.findOrder(2, new int[][]{{1, 0}});
    }

    /**
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = createGraph(numCourses, prerequisites);
        List<Node> list = sortTopological(graph, numCourses);
        if (list.size() != numCourses) {
            return null;
        }
        int[] result = new int[numCourses];
        int num = 0;
        for (int i = 0; i < result.length; i++) {
            result[num++] = list.get(i).value;
        }
        return result;
    }

    public List<Node> sortTopological(Graph graph, int numCourses) {
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> mapValue = new HashMap<>();
        // 查看哪个入度为0
        for (Node node : graph.nodes.values()) {
            mapValue.put(node.value, 1);
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        // 直接添加进去
        for (int i = 0; i < numCourses; i++) {
            if (!mapValue.containsKey(i)) {
                result.add(new Node(i));
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }

    public Graph createGraph(int numCourses, int[][] prerequisites) {
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
}
