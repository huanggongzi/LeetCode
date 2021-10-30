package com.company.图.决策流;

import com.company.图.Edge;
import com.company.图.Node;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:21
 * @Description:
 */
public class DecisionFlowPoint {
    public Policy policy;
    public int in;
    public int out;
    public ArrayList<DecisionFlowPoint> points;
    public ArrayList<DecisionFlowEdge> edges;

    public DecisionFlowPoint(Policy policy) {
        this.policy = policy;
        in = 0;
        out = 0;
        points = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
