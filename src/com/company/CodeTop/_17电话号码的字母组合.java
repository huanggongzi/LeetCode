package com.company.CodeTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2022/03/06/0:15
 * @Description:
 */
public class _17电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        chushihua(map);
        dfs(list, digits, path, 0, map);
        return list;
    }

    public void dfs(List<String> list, String digits, StringBuffer path, int index, HashMap<String, String> map) {
        if (index == digits.length()) {
            list.add(path.toString());
            return;
        }

        String str = map.get(digits.charAt(index) + "");

        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            dfs(list, digits, path, index + 1, map);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public void chushihua(HashMap<String, String> map) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxzy");
    }
}
