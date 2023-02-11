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
    	ListNode d = new ListNode(-1);
    	d.next = head;

    	ListNode prev = d;
    	ListNode curr = head;

    	while(curr != null && curr.next != null){
    		if(curr.val == curr.next.val){
    			//otherwise find the point where the next diff num comes up
    			ListNode f = curr.next;
    			while(f != null && f.val == curr.val){
    				f = f.next;
    			}
    			prev.next = f;
    			curr = f;
    		}else{
    			//simple move forward
    			prev.next = curr;
    			curr = curr.next;
    		}
    	}

    	return d.next;
    }


}