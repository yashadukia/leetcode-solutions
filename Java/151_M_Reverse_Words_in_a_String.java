class Solution {
    public String reverseWords(String s) {
        
        if (s == null)
            return "";
        
        s = s.trim();
        
        if (s.length() == 0)
            return "";
        
        if (s.length() <= 1)
            return s;
        
        StringBuilder sb = new StringBuilder();
        
        for (String x: s.split(" "))
        {
            if (x.trim().length() > 0)
            {
                sb.insert(0, x);
                sb.insert(0, " ");
            }
        }
        
        // Remove space from front which was added in the for loop above
        sb.deleteCharAt(0);
        
        return sb.toString();
    }
}