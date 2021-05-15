class Solution {
    public boolean isHappy(int n) {
        
        if (n == 1)
            return true;
        
        if (n == 0)
            return false;
        
        HashSet<Integer> set = new HashSet<>();
        
        set.add(n);
        
        int ans = n;
        
        while (ans != 1)
        {
            String temp = String.valueOf(ans);
            int res = 0;
            for (int i = 0; i < temp.length(); i++)
            {
                int x = (int)Math.pow(Character.getNumericValue(temp.charAt(i)), 2);
                res += x;
            }
            ans = res;
            
            if (set.contains(ans))
                return false;
            else
                set.add(ans);
        }
        return true;
    }
}