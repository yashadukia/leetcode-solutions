class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        
        // Base case
        int contains = 0;
        for (int x: nums)
        {
            if (x == 1)
            {
                contains++;
                break;
            }
        }
        
        if (contains == 0)
            return 1;
        
        if (n == 1)
            return 2;
        
        // Replace negative numbers, zeros, and numbers larger than n by 1s.
        // After this convertion nums will contain only positive numbers.
        for (int i = 0; i < n; i++)
        {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }
        
        // Change the sign to -ve of all numbers to their indices
        for (int i = 0; i < n; i++)
        {
            int a = Math.abs(nums[i]);
            
            // Since index n is out of bounds
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }
        
        // The first +ve index is the answer 
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > 0)
                return i;
        }
        
        if (nums[0] > 0)
            return n;
        
        return n+1;
        
        // O(n) space but works
//         if (nums == null)
//             return 0;
        
//         Set<Integer> set = new HashSet();
//         for (int x: nums)
//             set.add(x);
        
//         for (int i = 1; i <= nums.length; i++)
//         {
//             if (!set.contains(i))
//                 return i;
//         }
//         return nums.length+1;
    }
}