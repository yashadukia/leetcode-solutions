/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums.length < 3)
            return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++)
        {
            int low = i+1;
            int high = nums.length-1;
            
            // Skip repetition numbers from the array in the beginning. Allow 0th index
            if (i == 0 || nums[i] != nums[i-1])
            {
                while (low < high)
                {
                    if (nums[i] + nums[low] + nums[high] == 0)
                    {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // Optimization to remove repeated elements
                        while (low < high && nums[low] == nums[low+1])
                            low++;
                        // Optimization to remove repeated elements
                        while (low < high && nums[high] == nums[high-1])
                            high--;
                        // Increment and decrement based on sum is greater or smaller
                        low++;
                        high--;
                    }
                    else if (nums[i] + nums[low] + nums[high] > 0)
                        high--;
                    else
                        low++;
                }
            }
        }
        return res;
    }
}
