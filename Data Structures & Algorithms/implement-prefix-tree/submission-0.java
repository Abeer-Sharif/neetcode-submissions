public class TrieNode{
    HashMap<Character, TrieNode> child = new HashMap<>();
    boolean endOfWord=false;
}

public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for ( char c : word.toCharArray()){
            curr.child.putIfAbsent(c, new TrieNode());
            curr = curr.child.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.child.containsKey(c)){
                return false;
            }
            curr = curr.child.get(c);
        }
        return true;
    }
}
