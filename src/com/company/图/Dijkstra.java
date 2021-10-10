package com.company.图;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/09/28/23:47
 * @Description:
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node from) {
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

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> map, HashSet<Node> set) {
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
     * @param from
     * @return
     */

}
