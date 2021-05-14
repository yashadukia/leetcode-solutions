/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        helper(root, sum, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void helper(TreeNode root, int sum, int curr, List<Integer> slate, List<List<Integer>> res)
    {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null)
        {
            if (curr + root.val == sum)
            {
                slate.add(root.val);
                res.add(new ArrayList<>(slate));
                slate.remove(slate.size() - 1);
                return;
            }
        }
        
        slate.add(root.val);
        helper(root.left, sum, curr + root.val, slate, res);
        helper(root.right, sum, curr + root.val, slate, res);
        slate.remove(slate.size() - 1);
        
    }
}