
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int diff = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i = 0; i < nums.length-2; i++)
        {
            int low = i+1;
            int high = nums.length-1;
            
            // Skip repetition numbers from the array in the beginning. Allow 0th index
            if (i == 0 || nums[i] != nums[i-1])
            {
                while (low < high)
                {
                    int sum = nums[i] + nums[low] + nums[high];
                    
                    if (Math.abs(sum - target) < diff)
                    {
                        diff = Math.abs(sum - target);
                        res = sum;
                    }
                    if (target - sum < 0)
                        high--;
                    else
                        low++;
                }
            }
        }
        return res;
        
    }
}