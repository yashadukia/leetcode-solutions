/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
*/

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