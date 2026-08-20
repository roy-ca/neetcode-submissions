class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    Node() {}

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    boolean isEnd() {
        return flag;
    }

    void setEnd() {
        flag = true;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    // Helper method to handle recursive backtracking for wildcards ('.')
    private boolean match(String word, int index, Node node) {
        if (node == null) return false;
        
        // Base case: Reached the end of the search string
        if (index == word.length()) {
            return node.isEnd();
        }

        char ch = word.charAt(index);
        
        if (ch == '.') {
            // Wildcard character: Try all possible matching child branches
            for (Node child : node.links) {
                if (child != null && match(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard character: Follow the explicit character branch
            if (!node.containsKey(ch)) {
                return false;
            }
            return match(word, index + 1, node.get(ch));
        }
    }
}
