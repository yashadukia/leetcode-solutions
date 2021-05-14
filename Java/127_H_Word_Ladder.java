class Solution {
    
    Set<String> visited = new HashSet<>();
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        queue.add(beginWord);
        int level = 0;
        
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) 
            {
                String curr = queue.remove();
                char[] wordUnit = curr.toCharArray();
                
                if (curr.equals(endWord)) 
                {
                    return level + 1;
                }
                
                for (int j = 0; j < curr.length(); j++) 
                {
                    char temp = wordUnit[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) 
                    {
                        wordUnit[j] =c;
                        String s = new String(wordUnit);
                        
                        if (set.contains(s)) 
                        {
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                    wordUnit[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}