package com.company.前缀树;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱敲代码的小黄
 * @Date: 2021/10/19/23:09
 * @Description:
 */
public class TrieTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("黄良帅");
        trie.insert("黄良栋");
        trie.insert("李锐");
        System.out.println(trie.search("黄良帅"));   // 返回 True
        System.out.println(trie.search("黄良"));    // 返回 False);
        trie.startsWith("黄良"); // 返回 True
    }

    public static class Node {
        int pass;
        int end;
        Node[] nodes;

        public Node() {
            pass = 0;
            end = 0;
            nodes = new Node[26];
        }
    }

    public static class Trie1 {
        Node root = new Node();

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();

            Node node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (node.nodes[path] == null) {
                    node.nodes[path] = new Node();
                }
                node = node.nodes[path];
                node.pass++;
            }
            node.end++;
        }

        /**
         * 该字符串出现了几次
         *
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] str = word.toCharArray();
            Node node = root;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (node.nodes[path] == null) {
                    return 0;
                }
                node = node.nodes[path];
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            char[] str = word.toCharArray();
            Node node = root;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (--node.nodes[path].pass == 0) {
                    // Java垃圾回收直接回收掉
                    node.nodes[path] = null;
                    return;
                }
                node = node.nodes[path];
            }
            node.end--;
        }
    }
}

class Trie {
    int pass;
    int end;
    Map<Character, Trie> tries;

    public Trie() {
        pass = 0;
        end = 0;
        tries = new HashMap<>();
    }

    // "黄良帅"
    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Trie trie = this;
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (!trie.tries.containsKey(ch)) {
                trie.tries.put(ch, new Trie());
            }
            trie.pass++;
            trie = trie.tries.get(ch);
        }
        trie.end++;
    }

    // 查一个字符存不存在
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] str = word.toCharArray();
        Trie trie = this;
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (!trie.tries.containsKey(ch)) {
                return false;
            }
            trie = trie.tries.get(ch);
        }
        if (trie.end >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] str = prefix.toCharArray();
        Trie trie = this;
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            if (!trie.tries.containsKey(ch)) {
                return false;
            }
            trie = trie.tries.get(ch);
        }
        return true;
    }
}