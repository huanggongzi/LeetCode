package com.company.图.决策流;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:27
 * @Description:
 */
public class Policy {
    String policyUuid;
    int score;
    int num;
    String type;
    String field;

    public Policy(String policyUuid, int score, int num, String type, String field) {
        this.policyUuid = policyUuid;
        this.score = score;
        this.num = num;
        this.type = type;
        this.field = field;
    }

    public int getScore(int num, String field, String targetField) {
        if (field.equals(targetField) && num > this.num) {
            return score;
        }
        return 0;
    }
}
