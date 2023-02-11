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

	//using merge two sorted lists babyyyy! (that should be a thing too  yk) 
	public ListNode mergeKLists(ListNode[] lists) {
		//one by one keep merging the lists baby boi

		ListNode th = null;
		for(int i= 0; i < lists.length; i++){
			if(lists[i] != null){
				th = mergeTwoLists(lists[i], th);
			}
		}

		return th;
	}




	//merge sort method
    public ListNode mergeKLists(ListNode[] lists) {

    	//combine all lists into one
    	//apply mergesort & return

    	ListNode th = null;
    	ListNode curr = null;

    	int i = 0;
    	for(; i < lists.length; i++){
    		if(lists[i] != null){
    			th = lists[i];
    			curr = getTail(lists[i]);
    			break;
    		}
    	}

    	i++;
    	for(; i < lists.length; i++){
    		if(lists[i] != null){
    			curr.next = lists[i];
    			curr = getTail(lists[i]);
    		}
    	}

    	return sortList(th);
    }

    public ListNode getTail(ListNode head){
    	ListNode curr = head;
    	while(curr.next != null){
    		curr = curr.next;
    	}
    	return curr;
    }
}