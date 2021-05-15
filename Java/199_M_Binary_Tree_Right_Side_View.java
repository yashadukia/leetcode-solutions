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
    
    public List<Integer> res = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return res;
        
        helper(root, 0);
        return res;
    }
    
    public void helper(TreeNode root, int d)
    {
        if (root == null)
            return;
        
        // This will ensure the left nodes of the same depth are skipped
        if (d == res.size())
            res.add(root.val);
        
        // Go right first to exhaust right corner nodes 
        // As we want to print right side view and then left nodes
        helper(root.right, d+1);
        helper(root.left, d+1);
    }
}