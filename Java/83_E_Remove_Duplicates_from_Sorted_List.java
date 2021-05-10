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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null)
            return null;
        
        // Idea here is to save the head as prev and its value.
        // Go on as long as we dont see a new value and when you see it, 
        // point the prev saved to current temp and then in the end point prev to null.
        // The prev will always contain the first node of the duplciate values
        
        int prev_val = head.val;
        ListNode prev = head;
        ListNode temp = head.next;
        
        while (temp != null)
        {
            if (temp.val == prev_val)
            {
                temp = temp.next;
                continue;
            }
            else
            {
                prev.next = temp;
                prev = temp;
                prev_val = temp.val;
            }
        }
        prev.next = null;
        return head;
    }
}