package com.company.图.决策流;

import com.company.图.Edge;
import com.company.图.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:24
 * @Description:
 */
public class DecisionFlowGraph {
    public HashMap<Policy, DecisionFlowPoint> points;
    public Set<DecisionFlowEdge> edges;

    public DecisionFlowGraph() {
        points = new HashMap<>();
        edges = new HashSet<>();
    }
}
