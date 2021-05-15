class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int cmax = nums[0];
        int cmin = nums[0];
        
        // Max and min both are needed as the min might later multiply 
        // by another -ve number and become max
        for (int i = 1; i < nums.length; i++)
        {
            int nmax = nums[i] * cmax;
            int nmin = nums[i] * cmin;
            
            cmax = Math.max(nums[i], Math.max(nmax, nmin));
            cmin = Math.min(nums[i], Math.min(nmax, nmin));
            
            max = Math.max(max, cmax);
        }
        return max;
        
    }
}