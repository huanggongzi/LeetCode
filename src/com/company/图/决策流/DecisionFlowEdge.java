package com.company.图.决策流;

import com.company.图.Node;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:25
 * @Description:
 */
public class DecisionFlowEdge {
    DecisionFlowPoint from;
    DecisionFlowPoint to;

    public DecisionFlowEdge(DecisionFlowPoint from, DecisionFlowPoint to) {
        this.from = from;
        this.to = to;
    }
}
