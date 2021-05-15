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
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode left, ListNode right)
    {   
        ListNode head = new ListNode();
        ListNode temp = head;
        
        while (left != null && right != null)
        {
            if (left.val <= right.val)
            {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        
        temp.next = (left != null) ? left : right;
        return head.next;
    }
    
    public ListNode getMid(ListNode head)
    {
        ListNode midPrev = null;
        
        while (head != null && head.next != null)
        {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        
        ListNode mid = midPrev.next;
        midPrev.next = null; // Breaking the first part before mid.
        return mid;
        
        // Below solution is good but doesnt work as we have to break it at slow.prev but its a singly linked list so cant go back
        
//         ListNode slow = head;
//         ListNode fast = head;
        
//         while (fast != null && fast.next != null)
//         {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
        
//         return slow;
    }
}