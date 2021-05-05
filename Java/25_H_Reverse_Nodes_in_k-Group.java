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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (k == 1)
            return head;
        
        ListNode temp = head;
        ListNode ktail = null;
        
        // Head of the final, moified linked list
        ListNode new_head = null;
        
        
        while (temp != null)
        {
            int count = 0;
            
            temp = head;
            
            while (count < k && temp != null)
            {
                temp = temp.next;
                count += 1;
            }
            // Here temp would be in the next block
            
            if (count == k)
            {
                ListNode revHead = reverseList(head, k);
                
                // Only first time
                if (new_head == null)
                {
                    new_head = revHead;
                }
                
                // ktail is tail of previous block
                if (ktail != null)
                    ktail.next = revHead; // prev tail .next is curr revHead
                
                ktail = head; // ktail will be old head
                head = temp; // old head will become next block curr old head
            }
        }
        
        if (ktail != null)
            ktail.next = head;
        
        return new_head == null ? head : new_head;
        
    }
    
    public ListNode reverseList(ListNode head, int k)
    {
        ListNode prev = null;
        ListNode temp = head;
        
        while (k > 0)
        {
            ListNode next = temp.next;
            
            temp.next = prev;
            prev = temp;
            
            temp = next;
            k--;
        }
        return prev;
    }
}