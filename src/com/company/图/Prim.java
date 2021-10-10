package com.company.图;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/10/17:38
 * @Description:
 */
public class Prim {
    public static class MyEdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> prim(Node node) {
        //代表是否走过
        Set<Node> setNodeVis = new HashSet<>();
        Set<Edge> setEdge = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new MyEdgeComparator());
        for (Edge edge : node.edges) {
            priorityQueue.add(edge);
        }
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            Node to = edge.to;
            // 看当前点是否被访问过
            if (!setNodeVis.contains(to)) {
                setEdge.add(edge);
                // 没有访问的话，加入访问标记，并且将其所有的边给放进去
                setNodeVis.add(to);
                for (Edge edge1 : to.edges) {
                    priorityQueue.add(edge1);
                }
            }
        }
        return setEdge;
    }
}
