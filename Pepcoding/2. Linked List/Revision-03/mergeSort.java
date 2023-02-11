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

	public ListNode mid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d = new ListNode(-1);
    	ListNode curr = d;

    	ListNode p1 = list1;
    	ListNode p2 = list2;

    	while(p1 != null && p2 != null){   
    		if(p1.val < p2.val){
    			curr.next = p1;
    			p1 = p1.next;

    		}else{
    			curr.next = p2;
    			p2 = p2.next;
    		}
    		curr = curr.next;
    	}

    	if(p1 != null){
    		curr.next = p1;
    	}

    	if(p2 != null){
    		curr.next = p2;
    	}

    	return d.next;
    }



    public ListNode sortList(ListNode head) {

    	if(head == null || head.next == null) return head;

    	//base case
    	ListNode mid = mid(head);

    	ListNode first = head;
    	ListNode second = mid.next;
    	mid.next = null;


    	//now one is at head, other is at shead
    	first = sortList(first);
		second = sortList(second);


    	//find 
    	head = mergeTwoLists(first, second);

    	return head;
    }
}