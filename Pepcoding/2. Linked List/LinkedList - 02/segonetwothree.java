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
        
        if(head == null || head.next == null){
            return head;
        }
        //let's solve for here
        ListNode dummy0 = new ListNode(-1);
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode curr= head;
        ListNode c0 = dummy0;
        ListNode c1 = dummy1;
        ListNode c2 = dummy2;
        ListNode f = null;

        while(curr != null){
            f = curr.next;
            curr.next = null;

            if(curr.val == 0){
                c0.next = curr;
                c0 = curr;
            }
            else if(curr.val == 1){
                c1.next = curr;
                c1 = curr;
            }else{
                c2.next = curr;
                c2 = curr;
            }
            
            curr = f;
        }

        //now let's join them 
        //now how will you join them, that's the important question for sure

        if(dummy1.next != null){
            c0.next = dummy1.next;
            c1.next = dummy2.next;
        }else{
            c0.next = dummy2.next;
        }
    
        return dummy0.next;
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