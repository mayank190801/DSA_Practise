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

	//simple find the linkedlist in this cycle code would work here for sure
	public ListNode detectCycle(ListNode head){
		ListNode s = head;
		ListNode f = head;

		boolean cycle = false;

		while(f != null && f.next != null){
			s = s.next;
			f = f.next.next;

			if(s == f){
				cycle = true;
				break;
			}
		}

		if(!cycle) return null;

		s = head;
		while(s != f){
			s = s.next;
			f = f.next;
		}

		return s;
	}

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    	//go to the end
    	ListNode curr = headA;
    	while(curr.next != null){
    		curr = curr.next;
    	}

    	curr.next = headB;
    	ListNode ans = detectCycle(headA);
    	curr.next = null;
    	return ans;
    }
}





