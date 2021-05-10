class Solution {
    
    List<String> res = new ArrayList<>();
    
    // https://www.youtube.com/watch?v=KU7Ae2513h0
    
    public List<String> restoreIpAddresses(String s) {
        
        // Store the parts of IP
        int[] path = new int[4];
        restore(s, 0, path, 0);
        
        return res;
    }
    //                           BuilderIdx, Parts of IP, segment out of 4 of the IP
    public void restore(String s, int idx, int[] path, int segment)
    {
        if (segment == 4 && s.length() == idx)
        {
            res.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }
        
        if (segment == 4 || s.length() == idx)
            return;
        
        for (int len = 1; len <= 3 && idx + len <= s.length(); len++)
        {
            String temp = s.substring(idx, idx + len);
            int val = Integer.parseInt(temp);
            
            if (val > 255 || len >= 2 && temp.charAt(0) == '0')
                break;
            
            path[segment] = val;
            restore(s, idx + len, path, segment + 1);
            path[segment] = -1;
        }
    }
}