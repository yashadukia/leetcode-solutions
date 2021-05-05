class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null)
            return null;
        
        int start = 0;
        int end = nums.length - 1;
        int l = -1;
        int r = -1;
         
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target)
            {
                while (mid >= 0 && nums[mid] == target)
                {
                    l = mid;
                    mid--;
                }
                mid++;
                while (mid < nums.length && nums[mid] == target)
                {
                    r = mid;
                    mid++;
                }
                return new int[]{l, r};
            }
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return new int[]{l, r};
    }
}