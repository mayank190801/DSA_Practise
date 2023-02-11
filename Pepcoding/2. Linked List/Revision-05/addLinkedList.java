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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode p1 = l1;
    	ListNode p2 = l2;

    	ListNode d = new ListNode(-1);
    	ListNode curr = d;

    	int rem = 0;
    	//doing both of this in same loop
    	while(p1 != null || p2 != null){
    		int num1 = p1 == null ? 0 : p1.val;
    		int num2 = p2 == null ? 0 : p2.val;

    		int sum = num1 + num2 + rem;
    		if(sum > 9) rem = 1; else rem = 0;

    		int val = sum%10;
    		ListNode node = new ListNode(val);
    		curr.next = node;
    		curr = curr.next;

    		if(p1 != null) p1 = p1.next;
    		if(p2 != null) p2 = p2.next;
    	}

    	if(rem != 0){
    		ListNode node = new ListNode(1);
    		curr.next = node;
    		curr = curr.next;
    	}

    	return d.next;
    }
}