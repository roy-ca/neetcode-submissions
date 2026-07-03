class PrefixTree {

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

           node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(node.get(ch) == null) {
                return false;
            }

            node = node.get(ch);
        }

        if(node.getEnd()) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {

        TrieNode node = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if(node.get(ch) == null) {
                return false;
            }

            node = node.get(ch);
        }

        return true;
    }
}

public class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean endOfWord = false;

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        endOfWord = true;
    }

    boolean getEnd() {
        return endOfWord;
    }
}
