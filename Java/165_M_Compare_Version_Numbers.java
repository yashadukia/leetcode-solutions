class Solution {
    public int compareVersion(String version1, String version2) {
        
        int p1 = 0;
        int p2 = 0;
        int n = version1.length();
        int m = version2.length();
        
        while (p1 < n || p2 < m)
        {
            int[] temp = getVal(version1, p1);
            int v1 = temp[0];
            p1 = temp[1]+1;
            
            temp = getVal(version2, p2);
            int v2 = temp[0];
            p2 = temp[1]+1;
            
            if (v1 != v2)
                return v1 > v2 ? 1 : -1;
        }
        return 0;
    }
    
    public int[] getVal(String s, int p)
    {
        if (p >= s.length())
            return new int[]{0, p};
        
        StringBuilder sb = new StringBuilder();
        
        while (p < s.length() && s.charAt(p) != '.')
        {
            sb.append(s.charAt(p));
            p = p+1;
        }
        
        return new int[]{Integer.parseInt(sb.toString()), p};
    }
}