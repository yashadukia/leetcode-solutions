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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
        
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        
        int carry = 0;
        
        while (l1 != null || l2 != null)
        {
            int v1 = 0;
            int v2 = 0;
            
            if (l1 != null)
            {
                v1 = l1.val;
                l1 = l1.next;
            }
                
            if (l2 != null)
            {
                v2 = l2.val;
                l2 = l2.next;
            }
            
            int res = v1 + v2 + carry;
            carry = res/10;
            temp.next = new ListNode(res%10);
            temp = temp.next;
        }
        
        if (carry > 0)
            temp.next = new ListNode(carry);

        return head.next;
    }
}