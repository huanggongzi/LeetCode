

public class _20220711实现一个魔法字典 {
    public static void main(String[] args) {
        System.out.println("111");
    }
}

class MagicDictionary {
    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
        // 递归的截止条件：当前的下标截止到字符串末尾并字典树结尾
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';

        // 如果当前的下一跳存在，则进入下一跳
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        // 如果不存在并且还没有更改过字符
        if (!modified) {
            // 更改字符，看下一跳的26个字符
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    // 看看下面的有无满足的
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie {
    boolean isFinished;
    Trie[] child;

    public Trie() {
        isFinished = false;
        child = new Trie[26];
    }
}
