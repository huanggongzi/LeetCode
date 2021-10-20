package com.company.前缀树;

import java.util.List;

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
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
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
    Trie[] tries;

    public Trie() {
        pass = 0;
        end = 0;
        tries = new Trie[26];
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] str = word.toCharArray();
        Trie trie = this;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (trie.tries[path] == null) {
                trie.tries[path] = new Trie();
            }
            trie.pass++;
            trie = trie.tries[path];
        }
        trie.end++;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] str = word.toCharArray();
        Trie trie = this;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (trie.tries[path] == null) {
                return false;
            }
            trie = trie.tries[path];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] str = prefix.toCharArray();
        Trie trie = this;
        int path = 0;
        for (int i = 0; i < str.length; i++) {
            path = str[i] - 'a';
            if (trie.tries[path] == null) {
                return false;
            }
            trie = trie.tries[path];
        }
        return true;
    }
}

class Node1 {
    int pass;
    int end;
    Node1[] tries;

    public Node1() {
        pass = 0;
        end = 0;
        tries = new Node1[26];
    }
}