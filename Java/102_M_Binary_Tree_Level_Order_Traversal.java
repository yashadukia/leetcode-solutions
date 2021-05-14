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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty())
        {
            TreeNode x = q.poll();
            
            if (x != null)
            {
                temp.add(x.val);
                
                if (x.left != null)
                {
                    q.add(x.left);
                }
                if (x.right != null)
                {
                    q.add(x.right);
                }
            }
            else
            {
                res.add(temp);
                
                if (q.peek() == null)
                    break;
                
                q.add(null);
                temp = new ArrayList<>();
                
            }
        }
        return res;
        
    }
}