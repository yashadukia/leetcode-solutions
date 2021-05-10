class Solution {
    public String simplifyPath(String path) {
        
        if (path == null)
            return null;
        
        Stack<String> st = new Stack();
        String[] parts = path.split("/");
        
        for (String dir: parts)
        {
            if (dir.equals(".") || dir.isEmpty())
                continue;
            else if (dir.equals(".."))
            {
                if (!st.isEmpty())
                    st.pop();
            }
            else
            {
                st.push(dir);
            }
                
        }
        
        if (st.isEmpty())
            return "/";
        
        StringBuilder res = new StringBuilder();
        
        while (!st.isEmpty())
        {
            res.insert(0, st.pop());
            res.insert(0, '/');
        }
        
        return res.toString();
    }
}