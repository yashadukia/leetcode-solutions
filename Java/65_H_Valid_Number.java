class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();
        
        if (s.length() == 0)
            return false;
        
        char[] c = s.toCharArray();
        int i = 0;
        
        boolean numSeen = false;
        boolean decimalSeen = false;
        boolean eSeen = false;
        
        if (c[i] == '+' || c[i] == '-')
            i++;
        
        while (i < c.length)
        {
            // if it is number
            if (c[i] >= '0' && c[i] <= '9')
            {
                numSeen = true;
            }
            // if it is e
            else if (c[i] == 'e')
            {
                // if we have not seen a number before 
                // or we have seen the e before then we return false
                if (!numSeen || eSeen)
                    return false;
                
                eSeen = true;
                // After seeing 'e', there should be atleast one number after 'e'
                numSeen = false;
            }
            // + or - 
            else if (c[i] == '-' || c[i] == '+')
            {
                // if pervious characer is not e then we return false
                // +- is allowed only after e
                if (c[i-1] != 'e')
                    return false;
            }
            // if '.' decimal
            else if (c[i] == '.')
            {
                // decimal is not allowed when it is alreay seen 
                // or we have seen e before
                if (decimalSeen || eSeen)
                    return false;
                
                decimalSeen = true;
            }
            else
                return false;
            
            i++;
        }
        
        return numSeen == false ? false : true;
    }
}