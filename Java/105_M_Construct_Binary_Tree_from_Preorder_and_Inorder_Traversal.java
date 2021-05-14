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
    
    private int pre_idx = 0;
    int[] pre;
    int[] in;
    // Used to map inorder array to their indexes
    // Inorder will tell us how to divide the trees
    Map<Integer, Integer> map = new HashMap<>();
    
    // Every pre element is a root of some subtree. Idea is to take the element from pre
    // One by one and find its 'idx' in Inorder and construct left and right subtree from there.
    // Elements to left of 'idx' is left subtree and to the right is right subtree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        pre = preorder;
        in = inorder;
        
        int idx = 0;
        for (int x: inorder)
            map.put(x, idx++);
        
        return helper(0, pre.length);
    }
    
    public TreeNode helper(int left, int right)
    {
        // No elements remain to construct subtrees
        if (left == right)
            return null;
        
        // This is the current root
        int val = pre[pre_idx];
        TreeNode root = new TreeNode(val);
        
        // Find the pivot which divides left and right subtree
        int in_index = map.get(val);
        pre_idx++;
        
        // Construct left and right subtrees
        root.left = helper(left, in_index);
        root.right = helper(in_index+1, right);
        return root;
    }
}