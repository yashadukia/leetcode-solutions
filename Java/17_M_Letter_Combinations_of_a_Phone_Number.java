/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/

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