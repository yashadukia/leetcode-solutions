class Solution {
    public int findMin(int[] nums) {
        
        // Linear Search O(n)
        
        // for (int i = 1; i < nums.length; i++)
        // {
        //     if (nums[i] < nums[i-1])
        //         return nums[i];
        // }
        // return nums[0];
        
        // Similar to https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ but with duplicates
        
        // Binary Search O(log n)
        
        int left = 0, right = nums.length - 1;
        while (left < right) 
        {
            int mid = left + ((right - left) / 2);
            
            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right]) 
                left = mid + 1;
            else
                right--;
        }
        return nums[left];
    }
}