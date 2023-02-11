import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //mid and reverse are needed for sure
    //size based middle and reverse are needed code it bruh
    public static ListNode mid(ListNode head){
    	ListNode slow = head;
    	ListNode fast = head;

    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
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

    public static void fold(ListNode head) {

    	if(head == null || head.next == null) return;

    	ListNode middle = mid(head);
    	ListNode nHead = middle.next;
    	middle.next = null;

    	ListNode revHead = reverseList(nHead);   //revised 600 questions in 15 days bruh

    	ListNode c1 = head;
        ListNode c2 = revHead;

        ListNode f1 = null, f2 = null;
        
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
        
    }

    

    public 

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
        fold(head);
        printList(head);
    }
}