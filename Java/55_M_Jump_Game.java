class Solution {
    public boolean canJump(int[] nums) {
        
        if (nums == null || nums.length <= 1)
            return true;
        
        int last = nums.length-1;
        int max = nums[0];
        
        for (int i = 0; i < nums.length; i++)
        {
            // Update the max at every point
            if (i + nums[i] > max)
                max = i + nums[i];
            
            // when i has reached max and value at nums[i] = 0 then false
            if (max == i && nums[i] == 0)
                return false;
            
            // when we can reach the last step
            if (max >= last)
                return true;
        }
        return false;
    }
}