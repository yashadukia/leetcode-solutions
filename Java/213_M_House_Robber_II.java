class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        int m1 = robHelper(nums, 0, nums.length-2);
        int m2 = robHelper(nums, 1, nums.length-1);
        
        return Math.max(m1, m2);
    }
    
    public int robHelper(int[] nums, int s, int e)
    {
        int t1 = 0;
        int t2 = 0;
        
        for (int i = s; i <= e; i++)
        {
            int temp = t1;
            int curr = nums[i];
            t1 = Math.max(t1, curr + t2);
            t2 = temp;
        }
        return t1;
    }
}