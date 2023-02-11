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

	//have to write two functions for this bad boi
	public ListNode mid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode reverseList(ListNode head){
		ListNode curr = head, prev = null, forw = null;
		while(curr != null){
			forw = curr.next;
			curr.next = prev;

			prev = curr;
			curr = forw;
		}

		return prev;
	}

    public boolean isPalindrome(ListNode head) {

    	if(head.next == null) return true;

    	ListNode middle = mid(head);
    	ListNode nhead = middle.next;
    	middle.next = null;

    	//now we have two lists basically
    	ListNode revHead = reverseList(nhead);

    	ListNode f = head;
    	ListNode s = revHead;

    	while(f != null && s != null){
    		if(f.val != s.val) return false;
    		f = f.next;
    		s = s.next;
    	} 
    	return true;
    }


}









