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
    public boolean isValidBST(TreeNode root) {
        
        // boolean ans = valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean ans = valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
        
    }
    
    public boolean valid(TreeNode root, long start, long end)
    {
        if (root == null)
            return true;
        
        if (root.val <= start || root.val >= end)
            return false;
        
        // Need 2 statements below for integer overflow case
        // And as we are passing null from the main function so to habdle that case
        // if (start != null && root.val <= start)
        //     return false;
        // if (end != null && root.val >= end)
        //     return false;
        
        // if (!valid(root.right, root.val, end))
        //     return false;
        // if (!valid(root.left, start, root.val))
        //     return false;
        return valid(root.left, start, root.val) && valid(root.right, root.val, end);
        // return true;
    }
}