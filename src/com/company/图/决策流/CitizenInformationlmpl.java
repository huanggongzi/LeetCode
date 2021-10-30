package com.company.图.决策流;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/30/15:37
 * @Description:
 */
public class CitizenInformationlmpl implements CitizenInformation {
    static HashMap<String, People> peopleCache = new HashMap<>();

    static {
        People people = new People("hls", "男", 21);
        peopleCache.put(people.name, people);
    }

    @Override
    public People getInformation(String name) {
        // 调用数据库，根据名字进行匹配
        return peopleCache.get(name);
    }
}
