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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null || n == 0)
            return head;
        
        ListNode temp = head;
        int count = 0;
        
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        
        int i = 0;
        temp = head;
        
        while (temp != null)
        {
            if (count - n == 0)
            {
                temp = temp.next;
                head = temp;
                break;
            }
            
            i++;
            
            if (i == count - n)
            {
                temp.next = temp.next.next;
                break;
            }
            
            temp = temp.next;
        }
        
        return head;
    }
}