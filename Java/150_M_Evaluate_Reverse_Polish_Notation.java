class Solution {
    public int evalRPN(String[] tokens) {
        
        if (tokens == null || tokens.length == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList(new String[]{"+","-","*","/"}));
        int res = 0;
        
        for (String s: tokens)
        {
            if (!set.contains(s))
            {
                st.push(Integer.parseInt(s));
                continue;
            }
            
            int x = st.pop();
            int y = st.pop();
            int temp = compute(x, y, s);
            st.push(temp);
        }
        if (st.size() >= 1)
            return st.pop();
        else
            return -1;
    }
    
    public int compute(int x, int y, String operator)
    {
        int res = 0;
        switch (operator)
        {
            case "+":
                res = y + x;
                break;
            case "-":
                res = y - x;
                break;
            case "*":
                res = y * x;
                break;
            case "/":
                res = y / x;
                break;
            default:
                break;
        }
        return res;
    }
}