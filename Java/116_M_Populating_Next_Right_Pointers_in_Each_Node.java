/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if (root == null)
            return null;
        
        // Recursive solution
        recurse(root, root.left, root.right);
        return root;
        
        // Iterative Solution
//         Queue<Node> q = new LinkedList<>();
        
//         q.add(root);
//         q.add(null);
        
//         while (!q.isEmpty())
//         {
//             Node x = q.poll();
            
//             if (x != null)
//             {
//                 x.next = q.peek();
                
//                 if (x.left != null)
//                     q.add(x.left);
//                 if (x.right != null)
//                     q.add(x.right);
//             }
//             else
//             {
//                 if (!q.isEmpty())
//                     q.add(null);
//             }
//         }
        
//         return root;
    }
    
    public void recurse(Node root, Node leftChild, Node rightChild)
    {
        if (leftChild == null)
            return;
        
        if (rightChild != null)
            leftChild.next = rightChild;
        else
            leftChild.next = null;
        
        if (root.next != null)
        {
            rightChild.next = root.next.left;
        }
        
        recurse(root.left, root.left.left, root.left.right);
        recurse(root.right, root.right.left, root.right.right);
        
    }
}