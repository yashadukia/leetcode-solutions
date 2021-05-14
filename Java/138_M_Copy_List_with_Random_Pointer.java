/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    Map<Node, Node> visited = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        
        if (head == null)
            return null;
        
        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        
        visited.put(oldNode, newNode);
        
        while(oldNode != null)
        {
            newNode.next = getClone(oldNode.next);
            newNode.random = getClone(oldNode.random);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return visited.get(head);
    }
    
    public Node getClone(Node node)
    {
        if (node != null)
        {
            if (visited.containsKey(node))
            {
                return visited.get(node);
            }
            else
            {
                visited.put(node, new Node(node.val));
                return visited.get(node);
            }
        }
        return null;
    }
}