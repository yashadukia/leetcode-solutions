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
    
    private int total = 0;
    
    public int sumNumbers(TreeNode root) {
        
        if (root == null)
            return 0;
        
        // String based approach
        // sum(root, "");
        
        // Int based approach
        sum(root, 0);
        
        return total;
    }
    
    // Int based approach - Optimized
    public void sum(TreeNode root, int curr)
    {
        if (root == null)
            return;
        
        curr = curr * 10 + root.val;
        
        if (root.left == null && root.right == null)
        {
            // curr += root.val;
            total += curr;
            return;
        }
        
        sum(root.left, curr);
        sum(root.right, curr);
    }
    
    // String based approach
    public void sum(TreeNode root, String curr)
    {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null)
        {
            curr += root.val;
            total += Integer.parseInt(curr);
            return;
        }
        
        sum(root.left, curr + root.val);
        sum(root.right, curr + root.val);
    }
}