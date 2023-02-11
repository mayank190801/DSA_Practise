import java.util.*;

    //sir version of code
    //pretty much same as mine to be honest
    //he is thinking less about the code i guess

    // i personally think my code was better myself
    //this is not at all an issue for sure
    public static void unfold(ListNode head){
        ListNode d1 = new ListNode(-1);
        ListNode d2 = new ListNode(-1);

        ListNode c1 = d1;
        ListNode c2 = d2;
        ListNode c = head;

        while(c != null){
            c1.next = c;
            c2.next = c.next;

            c1 = c1.next;
            c2 = c2.next;

            c = c.next;
            if(c != null)
                c = c.next;
        }

        c1.next = null;
        //after this remvove dummy node and shit
        ListNode rev = reverseList(d2.next);
        c1.next = rev;
    }


//below is my code, let's write sir code
// class Main {
//     public static class ListNode {
//         int val = 0;
//         ListNode next = null;

//         ListNode(int val) {
//             this.val = val;
//         }
//     }

//     public static ListNode reverse(ListNode head){
//         //simple recursion baby
//         ListNode curr = head, past = null, future = null;

//         while(curr != null){
//             future = curr.next;
//             curr.next = past;

//             past = curr;
//             curr = future;
//         }

//         return past;
//     }

//     public static void unfold(ListNode head) {
//         //two cases should be entertain always, one is not and is one yes
//         //we should solve in that order only!
//         ListNode p1 = head;
//         ListNode fhead = head.next;
//         ListNode p2 = head.next;

//         //logic for unfolding the
//         while(p1.next != null && p1.next.next != null){
//             ListNode temp1 = p1.next.next;
//             p1.next = temp1;
//             p1 = temp1;
//             ListNode temp2 = p2.next.next;
//             p2.next = temp2;
//             p2 = temp2;
//         }

//         if(p2 != null){
//             p1.next = null;
//         }

//         //now reverse and join
//         ListNode nhead = reverse(fhead);
//         p1.next = nhead;
    
//     }

//     static void printList(ListNode node) {
//         while (node != null) {
//             System.out.print(node.val + " ");
//             node = node.next;
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         ListNode dummy = new ListNode(-1);
//         ListNode prev = dummy;
//         while (n-- > 0) {
//             prev.next = new ListNode(scn.nextInt());
//             prev = prev.next;
//         }

//         ListNode head = dummy.next;
//         unfold(head);
//         printList(head);
//     }
// }