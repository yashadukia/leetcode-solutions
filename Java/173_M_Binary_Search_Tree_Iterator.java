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
class BSTIterator {
    
    ArrayList<Integer> sorted;
    int index;

    public BSTIterator(TreeNode root) {
        
        this.sorted = new ArrayList<>();
        int index = 0;
        this.inorder(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        
        return this.sorted.remove(0);
        
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        return this.sorted.size() > 0;
        
    }
    
    public void inorder(TreeNode root)
    {
        if (root == null)
            return;
        
        this.inorder(root.left);
        this.sorted.add(root.val);
        this.inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */