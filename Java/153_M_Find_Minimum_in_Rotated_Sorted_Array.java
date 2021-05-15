class Solution {
    
    // The question basically boils down to finding the rotate index. That is
    // from which index is the rotation starting and return the element at that index
    
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        
        // If sorted array is rotated then left is always > right
        if (nums[left] < nums[right] || nums.length == 1)
            return nums[0];
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid+1])
                return nums[mid+1];
            // go right
            if (nums[mid] > nums[left])
                left = mid+1;
            else
                right = mid;
        }
        return 0;
    }
}