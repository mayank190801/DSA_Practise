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
         ListNode forw = head;
         while(n --> 0){
            forw = forw.next;
         }

         ListNode d = new ListNode(-1);
         d.next = head;

         ListNode prev = d;
         ListNode curr = head;

         while(forw != null){
            forw = forw.next;
            prev = curr;
            curr = curr.next;
         }


         prev.next = curr.next;
         curr.next = null;

         return d.next;
    }
}