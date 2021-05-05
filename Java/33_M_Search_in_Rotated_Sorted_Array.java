class Solution {
    public int search(int[] nums, int target) {
        
        int n = nums.length;
        
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        
        int rotateIdx = find_rotate_index(nums);
        
        if (rotateIdx == 0)
            return searchBin(nums, target, 0, n-1);
        
        // [5,6,1,2,3,4] Assume 4 is target. It is less that nums[0]
        // so we search on the right side
        if (target < nums[0])
            return searchBin(nums, target, rotateIdx, n-1);
        
        // [3,4,5,6,1,2] Same as above but rotated differently
        return searchBin(nums, target, 0, rotateIdx);
            
    }
    
    // Binary Search in array
    public int searchBin(int[] nums, int target, int start, int end)
    {
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target)
                return mid;
            
            if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
    
    // Find the rotated index
    public int find_rotate_index(int[] nums)
    {
        int left = 0;
        int right = nums.length-1;
        
        // If not rotated. Just return 0
        if (nums[left] < nums[right])
            return 0;
        
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1])
                return mid+1;
            else
            {
                // take example [5,6,1,2,3,4]. 5(left) > 2(mid)
                // So we go left
                if (nums[left] > nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}