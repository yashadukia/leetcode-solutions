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
    
    private int total = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return total;
    }
    
    public int maxSum(TreeNode node)
    {
        if (node == null)
            return 0;
        
        int left_max = Math.max(maxSum(node.left), 0);
        int right_max = Math.max(maxSum(node.right), 0);
        
        // Find the max at this point
        int maxHere = node.val + left_max + right_max;
        
        total = Math.max(total, maxHere);
        
        // We choose left_max or right_max as when we return (go up the branch)
        // then path can only be made of edges used one time only. We cannot have a path
        // root->c->c1->c->c2. Each node can be used only once.
        return node.val + Math.max(left_max, right_max);
    }
}