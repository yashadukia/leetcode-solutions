class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        // See previous submits for a slower solution
        if (nums == null || nums.length == 0)
            return 0;
        
        int sum = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            
            // If the sum >= s. store the subarray length here and keep removing values
            // from sum from the start. Since we are summing the array
            // The sum will only increase cuz we have only +ve numbers
            while (sum >= s)
            {
                max = Math.min(max, i - min + 1);
                sum -= nums[min];
                min++;
            }
        }
        
        return max == Integer.MAX_VALUE ? 0 : max;
    }
}