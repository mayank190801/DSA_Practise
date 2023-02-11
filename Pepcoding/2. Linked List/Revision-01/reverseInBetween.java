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

	//you can use addFirst function in here
	public ListNode th = null, tt = null; 
	public ListNode reverseBetween(ListNode head, int left, int right) {

		th = null;
		tt = null;
		//something called dummy node!!
		ListNode d = new ListNode(-1);  
		d.next = head;
		head = d;

		int idx = 0;
		ListNode prev = null;
		ListNode curr = head;

		while(true){
			while(idx >= left && idx <= right){
				ListNode forw = curr.next;
				curr.next = null
				addFirst(curr);
				curr = forw;
				idx++;
			}

			if(idx > right){
				//set some pointers 
				tt.next = curr;
				prev.next = th;
				break;
			}

			prev = curr;
			curr = curr.next;
			idx++;
		}

		//after 
		return d.next;

	}

	public void addFirst(ListNode curr){
		//lode ka focus kaha hai?
		if(th == null){
			th = curr;
			tt = curr;
		}else{
			curr.next = th;
			th = curr;
		}
	}


	//MY SOLVE BASIC
	//this bitch ass code definitely works, but it takes more than once pass overall
	//now try thinking how you could do it in one pass for sure baby??
    public ListNode reverseBetween2(ListNode head, int left, int right) {

    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	head = dummy;


    	//now we have dummy on our side boss
    	ListNode one = dummy;
    	ListNode two = one.next;

    	//simply getting them align 
    	for(int i = 0; i < left - 1; i++){
    		one = one.next;
    		two = two.next;
    	}

    	ListNode three = two;
    	ListNode four = null;
    	for(int i = 0; i < right - left; i++){
    		three = three.next;
    	}

    	four = three.next;

    	//now do some stuff simply
    	three.next = null;
    	one.next = null;

    	//we will make three pointers
    	ListNode curr = two, prev = null, forw = null;
    	while(curr != null){
    		forw = curr.next;
    		curr.next = prev;

    		prev = curr;
    		curr = forw;
    	}

    	//after this simply reconnect everything and move on
    	one.next = three;
    	two.next = four;

    	head = head.next;
    	dummy.next = null;

    	return head;

        
    }


}