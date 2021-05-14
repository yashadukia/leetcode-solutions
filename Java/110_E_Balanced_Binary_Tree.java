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
    // Top down approach
    public boolean isBalanced(TreeNode root) {
        
        if (root == null)
            return true;
        
        // Recurse this for finding length of every left and right subtree
        if (Math.abs(helper(root.left) - helper(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        
        return false;
        
    }
    
    // Find the length subtrees starting from current root 
    public int helper(TreeNode root)
    {
        if (root == null)
            return -1;
        
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}