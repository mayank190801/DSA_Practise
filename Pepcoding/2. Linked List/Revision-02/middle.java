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

	//remember the functions for this are pretty fucking simple too!! 
	//make one pointer go with speed of two!!!!!!! (remember that boi) - 

	//damn it ran perfectly on the first try boss
	//size based boss
    public ListNode middleNode(ListNode head) {
    	if(head == null || head.next == null) return head;

    	ListNode slow = head;
    	ListNode fast = head;

    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
    }

    //index based ka code likho
}