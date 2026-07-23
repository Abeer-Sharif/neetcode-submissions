class Solution {
    class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean isWord = false;

        public void add(String word) {
            TrieNode curr = this;

            for (char c : word.toCharArray()) {
                curr.child.putIfAbsent(c, new TrieNode());

                curr = curr.child.get(c);
            }

            curr.isWord = true;
        }
    }

    private Set<String> result;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        result = new HashSet<>();

        for (String word : words) {
            root.add(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        visit = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, "");
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || visit[r][c]
            || !node.child.containsKey(board[r][c])) {
            return;
        }

        visit[r][c] = true;

        node = node.child.get(board[r][c]);

        word += board[r][c];

        if (node.isWord) {
            result.add(word);
        }

        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        visit[r][c] = false;
    }
}