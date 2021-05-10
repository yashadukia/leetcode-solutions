class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums == null)
            return 0;
        
        int currMax = 0, totalMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++)
        {
            currMax += nums[i];
            
            if (currMax > totalMax)
                totalMax = currMax;
            
            // For only positive, put this if above the previous if and start totalMax = 0
            if (currMax < 0)
                currMax = 0;
        }
        
        return totalMax;
    }
}