class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        // for (int x: nums)
        //     System.out.println(x);
        int count = 1;
        int max = 1;
        
        for (int i = 0; i < nums.length-1; i++)
        {
            // For the case of duplicates. Think about [1,2,0,1]
            if (nums[i] == nums[i+1])
                continue;
            
            if (nums[i] + 1 == nums[i+1])
            {
                count++;
                max = Math.max(max, count);
                // System.out.println("max : "+max+" count: "+count);
            }
            else
                count = 1;
        }
        return max;
    }
}


// Another good solution - O(n)
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longest = 0;
//         Set<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             set.add(num);
//         }
        
//         for(int num : set) {
//             if(!set.contains(num - 1)) {
//                 int curLength = 1;
//                 int curNumber = num;
//                 while(set.contains(curNumber + 1)) {
//                     curLength++;
//                     curNumber++;
//                 }
                
//                 longest = Math.max(curLength, longest);
//             }
//         }
        
//         return longest;
//     }
// }