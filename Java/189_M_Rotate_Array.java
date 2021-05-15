class Solution {
    public void rotate(int[] nums, int k) {
        
        k = k % nums.length;
        int count = 0;
        
        for (int start = 0; count < nums.length; start++)
        {
            int current = start;
            int prev = nums[start];
            
            do {
                // Find the next number and store int in temp
                // Replace the next number with prev
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                
                // Make prev as temp and current as the next idx
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}