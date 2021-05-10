class Solution {
    public String minWindow(String s, String t) {
        
        // if (t.length() > s.length())
        //     return null;
        
        int[] dist = new int[128];
        for (char c: t.toCharArray())
        {
            dist[c]++;
        }
        
        int start = 0;
        int minStart = 0;
        int len = s.length()+1;
        int count = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            dist[c]--;
            
            if (dist[c] >= 0)
                count++;
            
            if (count == t.length())
            {
                while (dist[s.charAt(start)] < 0)
                {
                    dist[s.charAt(start)]++;
                    start++;
                }
                if (len > i - start + 1)
                {
                    minStart = start;
                    len = i - start + 1;
                }
            }
        }
        
        if (len < s.length()+1)
            return s.substring(minStart, minStart + len);
        else
            return "";
    }
}