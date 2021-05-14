class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // Both dp and bfs are equally good
        // O(n^2) algo - DP
        
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                // i sets the value true earlier, of the word in dict.
                // when j comes in, it will use what i changed in dp array
                if (dp[j] && set.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    // break;
                }
            }
        }
        return dp[s.length()];
        
        
        // O(n^2) algo - BFS
//         Set<String> set = new HashSet<>(wordDict);
//         Queue<Integer> q = new LinkedList<>();
//         int[] visited = new int[s.length()];
        
//         q.offer(0);
        
//         while (!q.isEmpty())
//         {
//             int start = q.poll();
            
//             if (visited[start] == 0)
//             {
//                 for (int end = start+1; end <= s.length(); end++)
//                 {
//                     if (set.contains(s.substring(start, end)))
//                     {
//                         q.add(end);
                        
//                         if (end == s.length())
//                             return true;
//                     }
//                 }
//                 visited[start] = 1;
//             }
//         }
        
//         return false;

    }
}