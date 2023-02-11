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

    public static ListNode segregate012(ListNode head) {
    	ListNode zero = new ListNode(-1);
    	ListNode one = new ListNode(-1);
    	ListNode two = new ListNode(-1);

    	ListNode zp = zero, op = one, tp = two;
    	ListNode curr = head;

    	while(curr != null){
    		if(curr.val == 0){
    			zp.next = curr;
    			zp = zp.next;
    		}else if(curr.val == 1){
    			op.next = curr;
    			op = op.next;
    		}else{
    			tp.next = curr;
    			tp = tp.next;
    		}
    		curr = curr.next;
    	}

    	zp.next = null;
    	op.next = null;
    	tp.next = null;

   		//figure the edge cases out no?

    	if(op == one){
    		zp.next = two.next;
    	}else{
    		zp.next = one.next;
    		op.next = two.next;
    	}

    	//there could be some edge cases for sure!!
    	if(op)

        return zero.next;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}