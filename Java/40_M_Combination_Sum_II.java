class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return res;
        
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), res);
        
        return res;
    }
    
    private void dfs(int[] candidates, int offSet, int target, List<Integer> combination, List<List<Integer>> res) 
    {
        // Weird why original submission didnt work. Check it out later. got it
        if(target == 0) 
        {
            res.add(new ArrayList<>(combination));
            return;
        }
        
        if(target < 0)
            return;
            
        for(int i = offSet; i < candidates.length; i++) {
            if (i == offSet || candidates[i] != candidates[i-1])
            {
                // Simulate taking the number
                combination.add(candidates[i]); //choose
                dfs(candidates, i + 1, target - candidates[i], combination, res);
                // Simulate NOT taking the number after recursion ends
                combination.remove(combination.size() - 1); //unchoose
            }
        }
    }
}