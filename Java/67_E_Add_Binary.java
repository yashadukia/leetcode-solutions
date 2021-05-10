class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0)
        {
            int sum = 0;
            int v1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? b.charAt(j) - '0' : 0;
            i--;
            j--;
            sum += v1 + v2 + carry;
            
            // (sum % 2) gets the sum to either 0 or 1
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        
        if (carry > 0)
        {
            // If there is a carry, it can only be one as max sum can be 3.
            // So 3/2 = 1
            sb.insert(0, 1);
        }
        
        return sb.toString();
    }
}