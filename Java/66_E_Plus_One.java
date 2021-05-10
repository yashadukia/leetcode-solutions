class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 0;
        digits[digits.length-1] += 1;
        
        List<Integer> res = new ArrayList<>();
        
        // Go from last element to front. If any elemnt is > 9
        // take div by 10 for carry and % 10 for the val
        // make carry 0 if current element is < 9 
        for (int i = digits.length-1; i >= 0; i--)
        {
            digits[i] += carry;
            
            if (digits[i] > 9)
                carry = digits[i] / 10;
            else
                carry = 0;
            
            res.add(0, digits[i] % 10);
        }
        
        // Add the carry if > 0
        if (carry > 0)
            res.add(0, carry);
        
        // Just copying elements from List to primitive array
        int[] ret = new int[res.size()];
        int i = 0;
        while (i < res.size())
        {
            ret[i] = res.get(i);
            i++;
        }
        return ret;
    }
}