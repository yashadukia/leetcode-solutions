class Solution {
    public int romanToInt(String s) {
        
        if (s == null)
            return 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        
        int total = 0;
        boolean flag = true;
        
        for (int i = s.length()-1; i > 0; i--)
        {
            int temp = 0;
            
            if(hm.get(s.charAt(i-1)) < hm.get(s.charAt(i)))
            {
                temp = hm.get(s.charAt(i)) - hm.get(s.charAt(i-1));
                total += temp;
                i--;
            }
            else
                total += hm.get(s.charAt(i));
            
            // It went into previous if so we already took the first element
            if (i == 0)
                flag = false;
        }
        
        // The case when first element was bigger than second so we have to add it
        if (flag)
            total += hm.get(s.charAt(0));
            
        return total;
        
    }
}