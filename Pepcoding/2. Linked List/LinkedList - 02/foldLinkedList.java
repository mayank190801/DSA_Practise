import java.util.*;

///i have something to say or basically write a note about this question
//we could use addFirst method th and tt 
//with zero at th and one at tt


//other method is dummy one which sir
//one more method is what i did, that is again and again sending one to the beginning of the code
//i feel all of them are equally good and now i should move on

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mid(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

         while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head){
        ListNode curr= head, past =null, future = null;

        while(curr != null){
            future = curr.next;
            curr.next = past;

            past = curr;
            curr = future;
        }

        return past;
    }

    public static void fold(ListNode head) {
        //so this is the point where we will get head, and we would have to solve it 
        //first find the mid
        ListNode mid = mid(head);
        ListNode fhead = mid.next;
        mid.next= null;
        ListNode nhead = reverse(fhead);

        //now i have two list and i have to simply connect them one after another
        ListNode p1 = head;
        ListNode p2 = nhead;

        while(p1 != null && p2 != null){
            //now think of the logic in here
            ListNode fut1 = p1.next;
            p1.next = p2;
            p1 = fut1;
            ListNode fut2 = p2.next;
            p2.next = p1;
            p2 = fut2;

        }
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
        fold(head);
        printList(head);
    }
}