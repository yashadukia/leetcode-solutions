class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        if (nums == null)
            return null;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++)
        {
            if (hm.containsKey(nums[i]))
            {
                result[0] = hm.get(nums[i]);
                result[1] = i;
                return result;
            }
            int temp = target - nums[i];
            hm.put(temp,i);
        }
        return result;
    }
}