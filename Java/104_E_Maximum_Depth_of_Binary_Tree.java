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
    
    private int depth = 0;
    
    public int maxDepth(TreeNode root) {
        
        // if (root == null)
        //     return depth;
        
        findMax(root, 1);
        return depth;
    }
    
    // Traverse in inorder or preorder fashion and keep increasing level
    // When level > depth. Update depth and return depth in driver func
    public void findMax(TreeNode root, int level)
    {
        if (root == null)
            return;
        
        if (level > depth)
            depth = level;
        
        findMax(root.left, level+1);
        findMax(root.right, level+1);
    }
}