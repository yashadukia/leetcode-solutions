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
    
    private int target;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        
        return helper(root, sum, 0);
        
    }
    
    public boolean helper(TreeNode root, int sum, int curr)
    {
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null)
        {
            if (curr + root.val == sum)
            {
                return true;
            }
        }
        
        return (helper(root.left, sum, curr + root.val) || helper(root.right, sum, curr + root.val));
    }
}