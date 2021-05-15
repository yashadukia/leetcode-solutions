class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        // Choose which is better. curr or prev
        dp[1] = Math.max(dp[0], nums[1]);
        
        // At each iteration. Choose if dp[i-1] is more or nums[i]+dp[i-2] was more
        // Means either prev house or curr house + prev of prev house
        for (int i = 2; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length - 1];
    }
}