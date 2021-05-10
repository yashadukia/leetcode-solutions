class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        Arrays.sort(nums);
        
        gen(nums, 0, curr, res);
        return res;
    }
    
    public void gen(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res)
    {
        // Adding as new ArrayList as we're modifying the curr list
        // System.out.println(curr);
        res.add(new ArrayList<>(curr));
        
        for (int i = idx; i < nums.length; i++)
        {
            if (i == idx || nums[i] != nums[i-1])
            {
                curr.add(nums[i]);
                gen(nums, i+1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}