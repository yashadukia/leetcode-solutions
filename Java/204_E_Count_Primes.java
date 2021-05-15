class Solution {
    public int countPrimes(int n) {
        
        if (n <= 2)
            return 0;
        
        boolean[] prime = new boolean[n];
        // Arrays.fill(prime, true);
        int count = 0;
        
        for (int i = 2; i < n; i++)
        {
            // If the number is a prime, count++ and mark all prime * 1, prime * 2 .... as true; otherwise do nothing.
            if (!prime[i])
            {
                count++;
                
                int fac = 2;
                while (i * fac < n)
                {
                    prime[i * fac] = true;
                    fac++;
                }
            }
        }
        return count;
    }
}