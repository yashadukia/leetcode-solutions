class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (candidates.length == 0)
            return res;
        
        Arrays.sort(candidates);
        
        helper(candidates, 0, new ArrayList<Integer>(), target, res);
        return res;
        
    }
    
    public void helper(int[] candidates, int idx, List<Integer> curr, int target, List<List<Integer>> res)
    {
        if (target == 0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if (target < 0)
            return;
        
        for (int i = idx; i < candidates.length && target >= candidates[i]; i++)
        {
            // if (target >= candidates[i])
            // {
                // Simulate taking the number
                curr.add(candidates[i]);
                // See the use of "i" below instead of idx
                helper(candidates, i, curr, target - candidates[i], res);
                // Simulate NOT taking the number after recursion ends
                curr.remove(curr.size() - 1);
            // }
        }
        
    }
}