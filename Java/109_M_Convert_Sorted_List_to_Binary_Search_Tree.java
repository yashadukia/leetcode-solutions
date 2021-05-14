/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    
    public TreeNode sortedListToBST(ListNode head) {
        
        // Solution 1
        // List<Integer> nums = new ArrayList<>();
        // makeArray(nums, head);
        // return helper(nums, 0, nums.size() - 1);
        
        // Solution 2
        return helper(head);
    }
    
    // Solution 2 -> Pure recursion. No extra space
    
    private TreeNode helper(ListNode head){
        //base case
        if (head == null)
            return null;
        else if (head.next == null)
            return new TreeNode(head.val);
        
        //Recursive code
        ListNode fast = head;
        ListNode slow = head; //find mid point
        ListNode prev = null;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        ListNode middle = slow;
        TreeNode node = new TreeNode(middle.val);
        
        if(prev != null)
        {
            //break the list and send to helper
            prev.next = null;
            node.left = helper(head);
        }
        node.right = helper(middle.next);
        return node;
    }
    
    
    // Solution 1 -> Make an array and create tree
    
//     public void makeArray(List<Integer> nums, ListNode head)
//     {
//         while (head != null)
//         {
//             nums.add(head.val);
//             head = head.next;
//         }
//     }
    
//     public TreeNode helper(List<Integer> nums, int left, int right)
//     {
//         if (left > right)
//             return null;
        
//         int mid = (left + right) / 2;
        
//         TreeNode root = new TreeNode(nums.get(mid));
//         root.left = helper(nums, left, mid-1);
//         root.right = helper(nums, mid+1, right);
//         return root;
//     }
}