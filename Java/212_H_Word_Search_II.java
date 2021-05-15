class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String isWord = null;
}

// Wrote majority by myself
class Solution {
    
    char[][] grid;
    List<String> res = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {    
        
        grid = board;
        
        // Construst the Trie
        TrieNode root = new TrieNode();
        
        for (String word: words)
        {
            TrieNode temp = root;
            
            for (Character c: word.toCharArray())
            {
                if (!temp.children.containsKey(c))
                {
                    temp.children.put(c, new TrieNode());
                }
                temp = temp.children.get(c);
            }
            temp.isWord = word;
        }
        
        // Iterate over every cell and backtrack if we find a child of trie root = grid[row][col] 
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                if (root.children.containsKey(grid[row][col]))
                {
                    // System.out.println(grid[row][col]);
                    backtrack(row, col, root);
                }
            }
        }
        return res;
    }
    
    public void backtrack(int row, int col, TrieNode root)
    {
        // Think exmaple case
        // Currently grid is at 'o' of oath. need to get 'o' in trie as first we just got root
        // Store the letter as we will mark it as '#' for visited and re-assign later
        Character letter = grid[row][col];
        TrieNode curr = root.children.get(letter);
        
        // Use of making isWord as String. if not null, then add isWord to res.
        // Then mark it as null. Think dog and dogs, both follow the same path in trie.
        // Notice there is no return as we want to continue to 'dogs' in the above example
        if (curr.isWord != null)
        {
            res.add(curr.isWord);
            curr.isWord = null;
        }
        
        // A way of marking as visited
        grid[row][col] = '#';
        
        int[] rowOffset = {0, -1, 0, 1};
        int[] colOffset = {-1, 0, 1, 0};
        
        // Check all 4 sides of the current char.
        // if within grid bounds and the TrieNode 'curr' contains new char formed by 'newrow' and 'newcol', then recurse with root as 'curr'.
        // We just check if the children key exists. We will fetch the child node when recursing
        for (int i = 0; i < 4; i++)
        {
            int newrow = row+rowOffset[i];
            int newcol = col+colOffset[i];
            
            if (newrow >= 0 && newcol >= 0 && newrow < grid.length && newcol < grid[0].length)
            {
                if (curr.children.containsKey( grid[newrow][newcol] ))
                    backtrack(newrow, newcol, curr);
            }
        }
        
        grid[row][col] = letter;
    }
}