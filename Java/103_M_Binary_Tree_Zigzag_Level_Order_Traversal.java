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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        zigzag(root, 0, res);
        return res;
        
    }
    
    public void zigzag(TreeNode root, int level, List<List<Integer>> res)
    {
        if (root == null)
            return;
        
        if (level == res.size())
        {
            res.add(new ArrayList<Integer>());
        }
        
        if (level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        
        zigzag(root.left, level+1, res);
        zigzag(root.right, level+1, res);
    }
}