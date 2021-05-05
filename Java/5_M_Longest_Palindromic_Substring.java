
class Solution {
    private int start = 0, end = 0;
    
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 1)
            return s;
        
        
        for (int i = 0; i < s.length() - 1; i++)
        {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i+1);
        }
        
        return s.substring(start, start+end);
    }
    
    public void isPalindrome(String s, int i, int j)
    {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            if (end < j - i + 1)
            {
                start = i;
                end = j - i + 1;
            }
            i--;
            j++;
        }
    }
}