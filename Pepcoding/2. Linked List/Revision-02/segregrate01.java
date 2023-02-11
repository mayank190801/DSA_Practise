import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregate01(ListNode head) {
    	ListNode d1 = new ListNode(-1);
    	ListNode d2 = new ListNode(-1);

    	ListNode zero = d1;
    	ListNode one = d2;

    	ListNode curr = head;
    	while(curr != null){
    		if(curr.val == 1){
    			one.next = curr;
    			one = one.next;
    		}else{
    			zero.next = curr;
    			zero = zero.next;
    		}

    		curr = curr.next;
    	}

    	//simply have few poiters no? 
    	one.next = null;
    	zero.next = null;

    	zero.next = d2.next;
    	d2.next = null;
    	d1.next = null;

        return head;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);
        h1 = segregate01(h1);
        printList(h1);
    }
}