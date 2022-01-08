package com.company.图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/28/23:47
 * @Description:
 */
public class Dijkstra {
    public HashMap<Node, Integer> dijkstra1(Node from) {
        // 创建一个点 from 到达其他各位置的 map 映射
        HashMap<Node, Integer> map = new HashMap<>();
        // 将 from 自己到达自己的距离设置为 0
        map.put(from, 0);
        // 当前已经确定的点,便于后续进行筛选
        HashSet<Node> set = new HashSet<>();

        // 找到最小的点
        Node minNode = getMinDistanceAndUnselectedNode(map, set);
        while (minNode != null) {
            // 遍历该点的所有边
            for (Edge edge : minNode.edges) {
                if (map.containsKey(edge.to)) {
                    // 如果该点被访问过，则需要看一下到达该点
                    if (edge.weight + map.get(minNode) < map.get(edge.to)) {
                        map.put(edge.to, edge.weight + map.get(minNode));
                    }
                } else {
                    // 如果该点还没有被访问过
                    map.put(edge.to, edge.weight + map.get(minNode));
                }
            }
            set.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(map, set);
        }
        return map;
    }

    public Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> map, HashSet<Node> set) {
        Node minNode = null;
        int minValue = Integer.MAX_VALUE;
        for (Node node : map.keySet()) {
            if (!set.contains(node)) {
                if (map.get(node) <= minValue) {
                    minNode = node;
                    minValue = map.get(node);
                }
            }
        }
        return minNode;
    }

    /**
     * 迪杰特斯拉的优化版本：
     *
     * @param from
     * @return
     */
    public static HashMap<Node, Integer> dijkstra(Node from) {
        // key:点,value:距离;
        HashMap<Node, Integer> map = new HashMap<>();
        // 到自己的距离为0
        map.put(from, 0);
        // 筛选已经去除的点
        HashSet<Node> set = new HashSet<>();
        Node minNode = getMin(map, set);
        while (minNode != null) {
            // 当前的所有边
            ArrayList<Edge> edges = minNode.edges;
            for (Edge edge : edges) {
                Node to = edge.to;
                if (!set.contains(to)) {
                    if (map.containsKey(to)) {
                        map.put(to, Math.min(edge.weight + map.get(minNode), map.get(to)));
                    } else {
                        map.put(to, edge.weight);
                    }
                }
            }
            set.add(minNode);
            minNode = getMin(map, set);
        }
        return map;
    }


    public static Node getMin(HashMap<Node, Integer> map, HashSet<Node> set) {
        int min = Integer.MAX_VALUE;
        Node minNode = null;
        for (Node key : map.keySet()) {
            if (map.get(key) < min && !set.contains(key)) {
                min = map.get(key);
                minNode = key;
            }
        }
        return minNode;
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = createGraph(times);
        Node from = new Node(k);
        HashMap<Node, Integer> map = dijkstra1(from);
        if(map.size() != n){
            return -1;
        }
        int max = -1;
        for(Integer value : map.values()){
            max = Math.max(max, value);
        }
        return max;
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
    public static Graph createGraph(int[][] matrix) {
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
}
