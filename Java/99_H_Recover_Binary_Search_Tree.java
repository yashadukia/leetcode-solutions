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
    
    TreeNode x = null, y = null, pred = null;
    
    public void recoverTree(TreeNode root) {
        
        // One simple soolution is to do an inorder traversal and find the two swapped nodes
        // Look for decreseing elements from left to right and swap them
        
        // Recursive solution without extra space is below (using the same concept)
        findSwappedNodes(root);
        swap();
    }
    
    public void findSwappedNodes(TreeNode root)
    {
        if (root == null)
            return;
        
        // Start inorder
        findSwappedNodes(root.left);
        
        // Here pred starts from bottom node on left side so it cannot be greater than its parent
        // pred keeps changing
        if (pred != null && pred.val > root.val)
        {
            y = root;
            
            // Once we find x, we return the second time without going any further
            if (x == null)
                x = pred;
            else
                return;
        }
        pred = root;
        
        findSwappedNodes(root.right);
    }
    
    public void swap()
    {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}