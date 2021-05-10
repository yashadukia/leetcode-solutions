class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        gen(nums, 0, curr, res);
        return res;
    }
    
    public void gen(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res)
    {
        // Adding as new ArrayList as we're modifying the curr list
        res.add(new ArrayList<>(curr));
        
        for (int i = idx; i < nums.length; i++)
        {
            curr.add(nums[i]);
            gen(nums, i+1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}