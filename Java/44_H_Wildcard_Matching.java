class Solution {
    public boolean isMatch(String s, String p) {
        
        int slen = s.length();
        int plen = p.length();
        int sidx = 0;
        int pidx = 0;
        
        int staridx = -1;
        int tempidx = -1;
        
        while (sidx < slen)
        {
            if (pidx < plen && (p.charAt(pidx) == '?' || p.charAt(pidx) == s.charAt(sidx)))
            {
                sidx++;
                pidx++;
            }
            else if (pidx < plen && p.charAt(pidx) == '*')
            {
                staridx = pidx;
                tempidx = sidx;
                pidx++;
            }
            else if (staridx == -1)
                return false;
            else
            {
                pidx = staridx + 1;
                sidx = tempidx + 1;
                tempidx = sidx;
            }
        }
        
        for (int i = pidx; i < plen; i++)
        {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }
}