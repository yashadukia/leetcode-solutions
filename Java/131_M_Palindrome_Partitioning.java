class Solution {
    
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        
        backtrack(new ArrayList<>(), s, 0);
        return res;
    }
    
    public void backtrack(List<String> temp, String s, int idx)
    {
        if (idx == s.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < s.length(); i++)
        {
            if (isPalindrome(s.substring(idx, i+1)))
            {
                temp.add(s.substring(idx, i+1));
                backtrack(temp, s, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        
        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}