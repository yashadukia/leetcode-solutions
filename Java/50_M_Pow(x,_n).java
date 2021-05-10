class Solution {
    public double myPow(double x, int n) {
        
        long N = n;
        if (N < 0)
        {
            x = 1 / x;
            N = -N;
        }
        
        return helper(x, N);
    }
    
    // https://www.youtube.com/watch?v=wAyrtLAeWvI
    public double helper(double x, long n)
    {
        if (n == 0)
            return 1.0;
        
        double res = helper(x, n / 2);
        
        if (n % 2 == 0)
        {
            return res * res;
        }
        else
            return x * res * res;
    }
}