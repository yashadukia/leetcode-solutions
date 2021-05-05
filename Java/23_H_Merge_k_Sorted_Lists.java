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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        return mergeSort(lists,0,n-1);
    }
    public ListNode mergeSort(ListNode[] lists,int low,int high){
        if(low==high) return lists[low];
        int mid = low+(high-low)/2;
        ListNode first = mergeSort(lists,low,mid);
        ListNode second = mergeSort(lists,mid+1,high);
        return merge(first,second);
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode temphead = new ListNode(-1);
        ListNode temp = temphead;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;
        return temphead.next;
    }
}

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//         // Excellent solution https://leetcode.com/problems/merge-k-sorted-lists/discuss/724398/100-1ms-Java-solution-using-traditional-merge-sort!
//         // Above is very similar to mine but faster. see last submission
//         // Try Heap. That should also be fast
//         if (lists == null || lists.length == 0)
//             return null;
        
//         int n = lists.length;
        
//         int idx = 1;
        
//         while (idx < n)
//         {
//             // merge the current and previous list
//             lists[idx] = merge2(lists[idx-1], lists[idx]);
//             idx++;
//         }
//         // this leaves the final list in the last idx. return last list
//         return lists[n-1];
//     }
    
//     public ListNode merge2(ListNode l1, ListNode l2)
//     {
//         ListNode head = new ListNode(0);
//         ListNode temp = head;
        
//         while (l1 != null && l2 != null)
//         {
//             int val = 0;
//             if (l1.val <= l2.val)
//             {
//                 temp.next = l1;
//                 l1 = l1.next;
//             }
//             else
//             {
//                 temp.next = l2;
//                 l2 = l2.next;
//             }
//             temp = temp.next;
//         }
        
//         if (l1 == null)
//             temp.next = l2;
//         else if (l2 == null)
//             temp.next = l1;
        
//         return head.next;
//     }
// }