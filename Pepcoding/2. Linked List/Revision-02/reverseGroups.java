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

	//add first + recursion baby (best and easiest way to go down)
	//pretty pretty decent solve for sure (let's figure other stuff out for sure)

	ListNode th = null, tt = null;
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null) return head;
    	// th = null; tt = null;

    	ListNode temp = head;  //curr or head whatever you like
   
    	int rand = k;
    	while(rand--> 1){
    		temp = temp.next;
    		if(temp == null){
    			return head;
    		}
    	}

    	ListNode forw = temp.next;
    	ListNode nAhead = reverseKGroup(forw, k);

    	th = null; tt = null;

    	temp.next = null;
    	temp = head;
    	while(temp != null){
    		ListNode curr = temp.next;
    		temp.next = null;
    		addFirst(temp);
    		temp = curr;
    	}

    	tt.next = nAhead;
    	head = th;
    	th = null;
    	tt = null;

    	return head;
    }

    public void addFirst(ListNode temp){
    	if(th == null){
    		th = temp;
    		tt = temp;
    	}else{
    		temp.next= th;
    		th = temp;
    	}
    }



}










