
class Solution {
    public int myAtoi(String str) {
        
        if (str == null || str.length() < 1)
            return 0;
        
        int i = 0;
        
        while (i <str.length() && str.charAt(i) == ' ')
        {
            i++;
        }
        
        char flag = '+';
        
        if (i < str.length() && str.charAt(i) == '-')
        {
            flag = '-';
            i++;
        }
        else if (i < str.length() && str.charAt(i) == '+')
            i++;
        
        double result = 0;
        
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
        {
            result  = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        if (flag == '-')
            result = -result;
        
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) result;
        
    }
}