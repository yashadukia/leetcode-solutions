class Solution {
    public String countAndSay(int n) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder inter = new StringBuilder();
        String[] res = new String[n+1];
        
        res[1] = "1";
        
        if (n == 1)
            return res[n];
        
        for (int i = 2; i <= n; i++)
        {
            String temp = res[i-1];
            inter.append(temp.charAt(0));
            
            for (int j = 1; j < res[i-1].length(); j++)
            {
                if (temp.charAt(j) == temp.charAt(j-1))
                {
                    inter.append(temp.charAt(j));
                }
                else
                {
                    sb.append(inter.length());
                    sb.append(inter.charAt(0));
                    inter = new StringBuilder();
                    inter.append(temp.charAt(j));
                }
            }
            
            if (inter.length() > 0)
            {
                sb.append(inter.length());
                sb.append(inter.charAt(0));
                res[i] = sb.toString();
                sb = new StringBuilder();
                inter = new StringBuilder();
            }
        }
        
        return res[n];
        
    }
}