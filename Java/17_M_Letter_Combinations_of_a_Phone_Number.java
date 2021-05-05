
class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        
        if (digits.length() == 0)
            return res;
        
        String[] map = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        helper(digits, 0, map, "", res);
        return res;
    }
    
    public void helper(String digits, int idx, String[] map, String curr, List<String> res)
    {
        if (curr.length() == digits.length())
        {
            res.add(curr);
            return;
        }
        
        String letters = map[digits.charAt(idx) - '0'];
        
        for (int i = 0; i < letters.length(); i++)
        {
            curr += letters.charAt(i);
            helper(digits, idx+1, map, curr, res);
            curr = curr.substring(0, curr.length()-1);
        }
        
    }
}