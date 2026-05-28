class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (Character c: word.toCharArray()) {
            if (curr.getChildNode(c) == null) {
                curr.initializeChildNode(c);
            }
            curr = curr.getChildNode(c);
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (Character c: word.toCharArray()) {
            if (curr.getChildNode(c) == null) {
                return false;
            }
            curr = curr.getChildNode(c);
        }
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (Character c: prefix.toCharArray()) {
            if (curr.getChildNode(c) == null) {
                return false;
            }
            curr = curr.getChildNode(c);
        }
        return true;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;
    
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }

    public TrieNode getChildNode(char c) {
        if (children.containsKey(c)) {
            return children.get(c);
        }
        return null;
    }

    public TrieNode initializeChildNode(char c) {
        children.put(c, new TrieNode());
        return children.get(c);
    }
}
