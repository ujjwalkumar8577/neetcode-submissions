class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return search(word.toCharArray(), 0, root);
    }

    public boolean search(char arr[], int i, TrieNode curr) {
        if (i >= arr.length) {
            return curr.isEndOfWord;
        }
        if (arr[i] == '.') {
            ArrayList<TrieNode> al = curr.getAllNodes();
            for (TrieNode node: al) {
                if (search(arr, i+1, node)) {
                    return true;
                }
            }
            return false;
        }
        if (curr.getChildNode(arr[i]) == null) {
            return false;
        }
        return search(arr, i+1, curr.getChildNode(arr[i]));
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

    public ArrayList<TrieNode> getAllNodes() {
        return new ArrayList<TrieNode>(children.values());
    }
}
