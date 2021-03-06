
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length < 1)
            return "";
        
        if (strs.length == 1)
            return strs[0];
        
        StringBuilder sb = new StringBuilder(strs[0]);
        
        for (int i = 1; i < strs.length; i++)
        {
            int f = sb.length();
            int s = strs[i].length();
            int j = 0;
            int k = 0;
            
            while (j < f && k < s && sb.charAt(j) == strs[i].charAt(k))
            {
                j++;
                k++;
            }
            
            // When deleting the index 'j'. The position of chars after 'j' will shift to the left. So, just keep deleting charAt(j) until the end
            while (j < sb.length())
                sb.deleteCharAt(j);
        }
        return sb.toString();
    }
}