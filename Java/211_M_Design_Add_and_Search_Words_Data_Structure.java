// class TrieNode {
//     Map<Character, TrieNode> children = new HashMap<>();
//     boolean word = false;
//     public TrieNode() {}
// }
class TrieNode{
    
    TrieNode[] child;
    boolean isWord;
    
    TrieNode(){
        this.child = new TrieNode[26];
        this.isWord = false;
    }
}

class WordDictionary {

    TrieNode trie;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        TrieNode node = trie;
        // Keep checking if the trie node has the char
        // if yes. go to it. If null, add it and go to it
        for (Character c: word.toCharArray())
        {
            if (node.child[c - 'a'] == null)
            {
                node.child[c - 'a'] = new TrieNode();
            }
            node = node.child[c - 'a'];
        }
        // Make isWord true
        node.isWord = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, trie, 0);
    }
    
    public boolean search (String word, TrieNode node, int idx)
    {
        if (idx == word.length())
            return node.isWord;
        
        if (word.charAt(idx) != '.')
        {
            if ( (node.child[word.charAt(idx) - 'a'] != null) && (search(word, node.child[word.charAt(idx) - 'a'], idx+1)) )
                return true;
            
            return false;
        }
        else // if '.'
        {
            for (TrieNode n: node.child)
            {
                if (n != null && search(word, n, idx+1))
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */