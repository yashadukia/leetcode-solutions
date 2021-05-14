class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.length() == 0 || s.length() == 1)
            return true;
        
        if (s == null)
            return false;
        
        s = s.toLowerCase();
        
        int start = 0;
        int end = s.length()-1;
        
        while (start < end)
        {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            // System.out.println("c1: "+c1+" c2: "+c2);
            // System.out.println("start: "+start+" end: "+end);
            
            if (!Character.isLetterOrDigit(c1))
            {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(c2))
            {
                end--;
                continue;
            }
            
            if (c1 == c2)
            {
                // System.out.println("c1: "+c1+" c2: "+c2);
                // System.out.println("start: "+start+" end: "+end);
                start++;
                end--;
            }
            else
                return false;
        }
        
        return true;
    }
}