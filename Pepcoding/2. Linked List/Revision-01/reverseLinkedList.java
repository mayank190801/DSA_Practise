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

	//three approaches are there basically
	//recursion
	//iterative
	//addFirst

	//RECURSION (run beautifully) (any better?)
    public ListNode reverseList(ListNode head) {   
    	if(head == null || head.next == null) return head;
    
    	//otheriwse - pretty same
    	ListNode ahead = head.next;
    	ListNode nhead = reverseList(ahead);

    	ahead.next = head;
    	head.next = null;
    	return nhead;
    }


    //ITERATIVE  (beautful four liner code)
    public ListNode reverseList2(ListNode head) {  
    	ListNode curr = head, prev = null, forw = null;
    	while(curr != null){
    		forw = curr.next;
    		curr.next = prev;

    		prev = curr;
    		curr = forw;
    	}

    	return prev;
    }

    //ADDFIRST
    public ListNode addFirst(ListNode head, ListNode node){
    	node.next = head;
    	head = node;
    	return head;
    }
    
    public ListNode reverseList3(ListNode head){
    	ListNode thead = null;
    	ListNode temp = head;
    	while(temp != null){
    		//rather than creating a new node in here
    		ListNode f = temp.next;
    		temp.next = null;
    		thead = addFirst(thead, temp);
    		temp = f;
    	}
    	head.next = null;
    	return thead;
    }

}








