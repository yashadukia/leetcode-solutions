class Solution {
    public void nextPermutation(int[] nums) {
        
        if (nums == null)
            return;
        
        int len = nums.length;      
        
        int i = nums.length - 2;
        
        // Find the first decreasing number
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        // Find the first number to the right just bigger than above
        // Swap it
        // Reverse the numbers after that index till end
        if (i >= 0)
        {
            int j = len - 1;
            while (j >= 0 && nums[i] >= nums[j])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int id)
    {
        int end = nums.length-1;
        for (int i = id; i < end; i++)
        {
            swap(nums, i, end);
            end--;
        }
    }
}