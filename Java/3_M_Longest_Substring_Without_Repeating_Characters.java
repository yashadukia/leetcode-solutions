class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.length() == 0)
            return 0;
        
        int start = 0, end = 0, maxStart = 0, maxEnd = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        char[] c = s.toCharArray();
        
        for (int i = 0; i < c.length; i++)
        {
            if (hm.containsKey(c[i]))
            {
                int idx = hm.get(c[i]);
                
                if (start < idx+1)
                    start = idx+1;
            }
            hm.put(c[i], i);
            end = i;
            
            if(end - start > maxEnd - maxStart)
            {
                maxStart = start;
                maxEnd = end;
            }
        }
        return maxEnd - maxStart + 1;
    }
}