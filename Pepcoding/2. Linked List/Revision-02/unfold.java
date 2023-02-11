import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

     public static ListNode reverseList(ListNode head){
    	ListNode curr = head, prev = null, forw = null;
    	while(curr != null){
    		forw = curr.next;
    		curr.next = prev;

    		prev = curr;
    		curr = forw;
    	}

    	return prev;
    }

    public static void unfold(ListNode head) {

    	if(head == null || head.next == null) return;
    	
    	ListNode rhead = head.next; 
    	ListNode c1 = head;
    	ListNode c2 = rhead;
    	ListNode f1 = null, f2 = null;

    	while(c2 != null){
    		f1 = c2.next;

    		if(f1 == null){
    			c1.next = null;
    			break;
    		}

    		f2 = f1.next;
    		
    		//now simply remove connections
    		c1.next = f1;
    		c2.next = f2;

    		c1 = f1;
    		c2 = f2;
    	}


    	//by now we would have seperate linked list
    	ListNode revHead = reverseList(rhead);
    	c1.next = revHead;

    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}