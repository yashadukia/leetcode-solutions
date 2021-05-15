class Solution {
    public int trailingZeroes(int n) {
        
        if (n == 0)
            return 0;
        
        int count = 0;
        
        // Just count how many pairs of 2 and 5 in the factors of n
        for (int i = 1; i <= n; i++)
        {
            int rem = i;
            
            while (rem % 5 == 0)
            {
                count++;
                rem /= 5;
            }
        }
        return count;
    }
}