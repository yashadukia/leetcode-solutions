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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if (root == null)
            return new ArrayList<>();
        
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        while (root != null)
        {
            res.add(root.val);
            st.push(root);
            root = root.left;
        }
        
        while (!st.isEmpty())
        {
            TreeNode x = st.pop();
            if (x.right != null)
            {
                x = x.right;
                
                while (x != null)
                {
                    res.add(x.val);
                    st.push(x);
                    x = x.left;
                }
            }
        }
        return res;
    }
}