class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        
        if (n == 0)
            return res;
        
        helper(n, 0, 0, "", res);
        return res;
    }
    
    public void helper(int n, int o, int c, String curr, List<String> res)
    {
        if (o == n && c == n)
        {
            res.add(curr);
            return;
        }
        
        if (o < n)
        {
            helper(n, o+1, c, curr+"(", res);
        }
        if (c < o)
        {
            helper(n, o, c+1, curr+")", res);
        }
    }
}