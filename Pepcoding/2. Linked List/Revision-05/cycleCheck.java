/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	//let's do this one bois
    public ListNode detectCycle(ListNode head) {
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

    	if(!cycle){
    		return null;
    	}

    	s = head;
    	while(s != f){
    		s = s.next;
    		f = f.next;
    	}

    	return s;

        
    }
}