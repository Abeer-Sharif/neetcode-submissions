public class TrieNode {
    HashMap<Character, TrieNode> child = new HashMap<>();
    boolean endOfWord = false;
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }


public void addWord(String word) {
    TrieNode curr = root;
    for (char c : word.toCharArray()) {
        curr.child.putIfAbsent(c, new TrieNode());

        curr = curr.child.get(c);
    }
    curr.endOfWord = true;
}

public boolean search(String word) {
    return dfs(word, 0, root);
}
private boolean dfs(String word, int index, TrieNode root) {
    TrieNode curr = root;
    if (index == word.length()) {
        return curr.endOfWord;
    }
    char c = word.charAt(index);
    if (c != '.') {
        if (!curr.child.containsKey(c)) {
            return false;
        }
        return dfs(word, index + 1, curr.child.get(c));
    }
    for (TrieNode node : curr.child.values()) {
        if (dfs(word, index + 1, node)) {
            return true;
        }
    }
    return false;
}
}
