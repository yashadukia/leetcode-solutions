class Solution {
    public int jump(int[] nums) {
        
        if (nums.length < 2)
            return 0;
        
        // Largest idx we can reach in current jump
        int maxPos = nums[0];
        // Max steps within current jump
        int maxSteps = maxPos;
        int jumps = 1;
        
        for (int i = 1; i < nums.length; i++)
        {
            // If i goes beyond current maxSteps then we need another jump
            if (i > maxSteps)
            {
                jumps++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
        
        
        
        
        
        
        
        // DP Solution - slow O(n2)
//         int[] dp = new int[nums.length];
        
//         dp[0] = 0;
        
//         for (int i = 0; i < nums.length; i++)
//         {
//             for (int j = i+1; j <= i + nums[i]; j++)
//             {
//                 if (j < nums.length)
//                 {
//                     if (dp[j] != 0)
//                         dp[j] = Math.min(dp[j], dp[i] + i);
//                     else
//                         dp[j] = dp[i] + 1;
//                 }
//             }
//         }
        
//         return dp[nums.length-1];
    }
}