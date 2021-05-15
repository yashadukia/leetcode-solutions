class Solution {
    public int calculate(String s) {
        
        if (s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        // we will start with + as the first number can be either - or +
        char op = '+';
        int currNum = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            char currChar = s.charAt(i);
            
            // The number can contain multiple digits. So make the full num first
            if (Character.isDigit(currChar))
            {
                currNum = (currNum * 10) + (currChar - '0');
            }
            // Push all + and - ops into stack, startting with + and make op = currChar
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1)
            {
                if (op == '/')
                    st.push(st.pop() / currNum);
                else if (op == '*')
                    st.push(st.pop() * currNum);
                else if (op == '+')
                    st.push(currNum);
                else if (op == '-')
                    st.push(-currNum);
                
                currNum = 0;
                op = currChar;
            }
        }
        
        // Add the whole stack and return
        int res = 0;
        
        while (!st.isEmpty())
        {
            res += st.pop();
        }
        return res;
    }
}