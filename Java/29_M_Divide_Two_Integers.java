class Solution {
    
    private static int HALF_INT_MIN = -1073741824;// -2**30;
    
    public int divide(int dividend, int divisor) {
        
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
         /* We need to convert both numbers to negatives.
        * Also, we count the number of negatives signs. */
        int neg = 2;
        
        if (dividend > 0)
        {
            neg--;
            dividend = -dividend;
        }
        if (divisor > 0)
        {
            neg--;
            divisor = -divisor;
        }
        
        List<Integer> powers = new ArrayList<>();
        List<Integer> doublesQ = new ArrayList<>();
        
        /* Nothing too exciting here, we're just making a list of doubles of 1 and
     * the divisor. This is pretty much the same as Approach 2, except we're
     * actually storing the values this time. */
        
        int powOf2 = -1;
        
        while (divisor >= dividend)
        {
            powers.add(powOf2);
            doublesQ.add(divisor);
            // Prevent needless overflows from occurring...
            if (divisor < HALF_INT_MIN)
                break;
                
            powOf2 += powOf2;
            divisor += divisor;
        }
        
        int quo = 0;
        /* Go from largest double to smallest, checking if the current double fits.
     * into the remainder of the dividend. */
        
        for (int i = doublesQ.size() - 1; i >=0; i--)
        {
            if (doublesQ.get(i) >= dividend)
            {
                // If it does fit, add the current powerOfTwo to the quotient.
                quo += powers.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doublesQ.get(i);
            }
        }
        
        /* If there was originally one negative sign, then
     * the quotient remains negative. Otherwise, switch
     * it to positive. */
        if (neg != 1)
            return -quo;
        
        return quo;
        
    }
}