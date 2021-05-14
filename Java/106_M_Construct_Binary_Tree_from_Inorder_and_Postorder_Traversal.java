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
    
    int[] in;
    int[] post;
    int postidx;
    
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        postidx = postorder.length-1;
        
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        
        return helper(0, postorder.length-1);
    }
    
    public TreeNode helper(int left, int right)
    {
        if (left > right)
            return null;
        
        // Current root
        int val = post[postidx];
        TreeNode root = new TreeNode(val);
        
        // The index of current root in inorder array
        int inidx = map.get(val);
        postidx--;
        
        root.right = helper(inidx+1, right);
        root.left = helper(left, inidx-1);
        
        return root;
    }
};