class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null)
            return res;
        
        int start = 0;
        
        List<Integer> curr = new ArrayList<>();
        for (int x: nums)
            curr.add(x);
        
        helper(nums, start, curr, res);
        return res;
    }
    
    public void helper(int[] nums, int start, List<Integer>curr, List<List<Integer>> res)
    {
        if (start == nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++)
        {
            Collections.swap(curr, start, i);
            helper(nums, start+1, curr, res);
            Collections.swap(curr, start, i);
        }
    }
}