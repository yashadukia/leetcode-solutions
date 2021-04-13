/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

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