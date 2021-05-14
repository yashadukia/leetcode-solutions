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
    
    public int d;
    
    public int minDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        
        d = Integer.MAX_VALUE;
        helper(root, 1);
        return d;
    }
    
    public void helper(TreeNode root, int level)
    {
        if (root == null)
            return;
        
        // Leaf node
        if (root.left == null && root.right == null)
        {
            d = Math.min(d, level);
        }
        
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}