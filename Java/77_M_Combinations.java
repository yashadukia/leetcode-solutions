class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<Integer> ip = new ArrayList<>();
        
        for (int i = 1; i <= n; i++)
            ip.add(i);
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(ip, k, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void helper(List<Integer> ip, int k, int idx, List<Integer> curr, List<List<Integer>> res)
    {
        if (curr.size() == k)
        {
            // System.out.println(curr);
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < ip.size(); i++)
        {
            curr.add(ip.get(i));
            // i+1 will give combinations and idx+1 will give permutations
            helper(ip, k, i+1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}