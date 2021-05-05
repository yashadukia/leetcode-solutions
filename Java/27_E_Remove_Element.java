class Solution {
    public int removeElement(int[] nums, int val) {
        
        int w = 0;
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == val)
                continue;
            nums[w++] = nums[i];
        }
        return w;
    }
}