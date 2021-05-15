class Solution {
    public int titleToNumber(String s) {
        
        int power = 0;
        int temp = 0;
        int sum = 0;
        
        // Take example 'ACE':
        // a. (E-A+1) * 26^0 + 0
        // b. (C-A+1) * 26^1 + (a)
        // c. (A-A+1) * 26^2 + (b)
        
        for (int i = s.length() - 1; i >= 0; i--)
        {
            char c = s.charAt(i);
            sum = ((c - 'A' + 1) * (int)Math.pow(26, power)) + temp;
            power++;
            temp = sum;
        }
        
        return sum;
    }
}