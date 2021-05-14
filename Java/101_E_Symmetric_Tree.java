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
    public boolean isSymmetric(TreeNode root) {
        
        if (root == null)
            return true;
        
        return check(root.left, root.right);
    }
    
    public boolean check(TreeNode leftSub, TreeNode rightSub)
    {
        if (leftSub == null && rightSub == null)
            return true;
        else if (leftSub != null && rightSub != null)
        {
            return (leftSub.val == rightSub.val && check(leftSub.left, rightSub.right) && check(leftSub.right, rightSub.left));
        }
        return false;
    }
}