class Solution {
    public String largestNumber(int[] nums) {
        
        String[] arr = new String[nums.length];
        
        for (int i = 0; i < nums.length; i++)
        {
            arr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String a, String b)
            {
                // we compare the numbers achieved by concatenating the pair
                // case of getting 30 3 instead of 3 30
                String t1 = a+b;
                String t2 = b+a;
                return t2.compareTo(t1); // +ve means t2 is greater
            }
        });
        
        if (arr[0].equals("0"))
            return "0";

        String res = "";
        
        for (String s: arr)
            res += s;
        return res;
    }
}