class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x: nums)
            map.put(x, map.getOrDefault(x,0) + 1);
        
        for (int i: map.keySet())
        {
            if (map.get(i) == 1)
                return i;
        }
        return 0;
    }
}