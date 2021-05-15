/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        if (headA == null || headB == null)
            return null;
        
        int l1 = len(headA);
        int l2 = len(headB);
        
        if (l1 > l2)
        {
            while (l1 != l2)
            {
                headA = headA.next;
                l1--;
            }
        }
        
        if (l2 > l1)
        {
            while(l2 != l1)
            {
                headB = headB.next;
                l2--;
            }
        }
        
        while(headA != null && headB != null)
        {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int len(ListNode x)
    {
        int count = 0;
        
        while (x != null)
        {
            count++;
            x = x.next;
        }
        
        return count;
    }
}