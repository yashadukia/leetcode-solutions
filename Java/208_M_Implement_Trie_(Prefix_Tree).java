class TrieNode {
    
    private TrieNode[] children;
    private boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
    
    public boolean containsChild(char c)
    {
        return children[c - 'a'] != null;
    }
    
    public TrieNode getNode(char c)
    {
        return children[c - 'a'];
    }
    
    public void putNode(char c, TrieNode node)
    {
        children[c - 'a'] = node;
    }
    
    public void setWord()
    {
        isWord = true;
    }
    
    public boolean getIsWord()
    {
        return isWord;
    }
}

class Trie {
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (!node.containsChild(c))
                node.putNode(c, new TrieNode());
            node = node.getNode(c);
        }
        node.setWord();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = searchHelper(word);
        return node != null && node.getIsWord();
    }
    
    public TrieNode searchHelper(String word)
    {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++)
        {
            if (node.containsChild(word.charAt(i)))
                node = node.getNode(word.charAt(i));
            else
                return null;
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchHelper(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */