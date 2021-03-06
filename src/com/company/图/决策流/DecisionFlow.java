package com.company.图.决策流;

import com.company.图.Graph;
import com.company.图.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:01
 * @Description:
 */
public class DecisionFlow {
    static Policy policyOne;
    static Policy policyTwo;
    static Policy policyThree;
    static Policy getPolicyFour;
    static HashMap<String, Policy> policyCache;
    static CitizenInformation citizenInformation;
    static int finalScore;

    static {
        policyOne = new Policy("1", 20, 8, "policy", "loginCount");
        policyTwo = new Policy("2", 30, 9, "policy", "PostingViolationCount");
        policyThree = new Policy("3", 0, 0, "interface", "");
        getPolicyFour = new Policy("4", 50, 18, "policy", "age");
    }

    static {
        policyCache = new HashMap<>();
        citizenInformation = new CitizenInformationlmpl();
        policyCache.put(policyOne.policyUuid, policyOne);
        policyCache.put(policyTwo.policyUuid, policyTwo);
        policyCache.put(policyThree.policyUuid, policyThree);
        policyCache.put(getPolicyFour.policyUuid, getPolicyFour);
    }

    /**
     * [1,3]
     * [2,3]
     * [3,4]
     *
     * @param matix
     * @return
     */
    public static DecisionFlowGraph initialization(int[][] matix) {
        DecisionFlowGraph decisionFlowGraph = new DecisionFlowGraph();
        for (int[] targrt : matix) {
            Policy from = policyCache.get(String.valueOf(targrt[0]));
            Policy to = policyCache.get(String.valueOf(targrt[1]));
            createGraph(from, to, decisionFlowGraph);
        }
        return decisionFlowGraph;
    }

    public static void createGraph(Policy from, Policy to, DecisionFlowGraph decisionFlowGraph) {
        if (!decisionFlowGraph.points.containsKey(from)) {
            decisionFlowGraph.points.put(from, new DecisionFlowPoint(from));
        }
        if (!decisionFlowGraph.points.containsKey(to)) {
            decisionFlowGraph.points.put(to, new DecisionFlowPoint(to));
        }
        DecisionFlowPoint fromPoint = decisionFlowGraph.points.get(from);
        DecisionFlowPoint toPoint = decisionFlowGraph.points.get(to);
        DecisionFlowEdge edge = new DecisionFlowEdge(fromPoint, toPoint);
        fromPoint.out++;
        toPoint.in++;
        fromPoint.edges.add(edge);
        fromPoint.points.add(toPoint);
        decisionFlowGraph.edges.add(edge);
    }


    public static void main(String[] args) {
        // 模拟用户的接口输入
        // 姓名：hls
        // 登录次数：8
        // 发帖违规数：10
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "hls");
        map.put("loginCount", "10");
        map.put("PostingViolationCount", "10");


        // 初始化决策流
        System.out.println("决策流初始化.......");
        int[][] matix = new int[][]{{1, 3}, {2, 3}, {3, 4}};
        DecisionFlowGraph graph = initialization(matix);

        // 获取最终的分数
        getScore(graph, map);
        System.out.println("最终得分：" + finalScore);
    }


    public static void getScore(DecisionFlowGraph graph, HashMap<String, String> map) {
        int num = 1;
        // 使用一个队列
        Queue<DecisionFlowPoint> queue = new LinkedList<>();

        // 遍历所有的点，找到入度为 0 的点
        for (DecisionFlowPoint point : graph.points.values()) {
            // 入度为0
            if (point.in == 0) {
                queue.add(point);
            }
        }

        // 当前的队列不为空
        while (!queue.isEmpty()) {
            // 弹出当前队列的头
            DecisionFlowPoint point = queue.poll();
            // 使用当前该点代表的策略集
            finalScore = finalScore + resolve(point, map);
            System.out.println("当前点的类型为："+ point.policy.type + "，使用完该点的分数为" + finalScore);
            // 将该点所连接的点的入度减一
            for (DecisionFlowPoint next : point.points) {
                next.in--;
                if (next.in == 0) {
                    queue.add(next);
                }
            }
        }
    }

    public static int resolve(DecisionFlowPoint point, HashMap<String, String> map) {
        if (point.policy.type.equals("policy")) {
            Policy policy = point.policy;
            String field = policy.field;
            // 传参的值
            int num = Integer.valueOf(map.get(field));
            return policy.getScore(num, field, field);
        } else if (point.policy.type.equals("interface")) {
            People people = citizenInformation.getInformation(map.get("name"));
            map.put("age", String.valueOf(people.age));
            return 0;
        }
        return 0;
    }
}

