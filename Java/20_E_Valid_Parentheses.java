class Solution {
    public boolean isValid(String s) {
        
        if (s == null || s.length() == 1)
            return false;
        
        if (s.length() == 0)
            return true;
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[')
            {
                st.push(c);
                continue;
            }
            
            if (!st.isEmpty())
            {
                char temp = st.pop();

                if (c == ')' && temp == '(' || c == '}' && temp == '{' || c == ']' && temp == '[')
                    continue;
                else
                    return false;
            }
            else
                return false;
        }
        
        if (!st.isEmpty())
            return false;
        
        return true;
    }
}