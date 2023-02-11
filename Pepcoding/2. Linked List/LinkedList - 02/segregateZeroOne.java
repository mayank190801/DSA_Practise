import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        
        ListNode(int val) {
            this.val = val;
        }
    }
        
    public static ListNode segregate01(ListNode head) {
          
        if(head == null || head.next == null){
            return head;
        }
        //let's solve for here
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode curr= head;
        ListNode c1 = dummy1;
        ListNode c2 = dummy2;
        ListNode f = null;

        while(curr != null){
            f = curr.next;
            curr.next = null;

            if(curr.val == 1){
                c1.next = curr;
                c1 = curr;
            }else{
                c2.next = curr;
                c2 = curr;
            }
            
            curr = f;
        }

        //now let's join them 
        c2.next = dummy1.next;
        return dummy2.next;
    }

}

// below is my direct version for the code
//let's try sir method
//   class Main {
//     public static Scanner scn = new Scanner(System.in);

//     public static class ListNode {
//         int val = 0;
//         ListNode next = null;

//         ListNode(int val) {
//             this.val = val;
//         }
//     }

//     public static ListNode addFirst(ListNode head, ListNode curr){
//         //simple shit
//         curr.next = head;
//         head = curr;
//         return head;
//     }

//     public static ListNode segregate01(ListNode head) {


//         if(head == null || head.next == null){
//             return head;
//         }
//         //the logic seems to be super simple 
//         ListNode curr = head.next;
//         ListNode past = head;

//         while(curr != null){
//             if(curr.val == 0){
//                 past.next = curr.next;
//                 curr.next = null;

//                 head = addFirst(head, curr);
//                 curr = past.next;
//             }else{
//                 past = curr;
//                 curr = curr.next; 
//             }

//         }

//         return head;
//     }

//     public static void printList(ListNode node) {
//         while (node != null) {
//             System.out.print(node.val + " ");
//             node = node.next;
//         }
//     }

//     public static ListNode createList(int n) {
//         ListNode dummy = new ListNode(-1);
//         ListNode prev = dummy;
//         while (n-- > 0) {
//             prev.next = new ListNode(scn.nextInt());
//             prev = prev.next;
//         }

//         return dummy.next;
//     }

//     public static void main(String[] args) {
//         int n = scn.nextInt();
//         ListNode h1 = createList(n);
//         h1 = segregate01(h1);
//         printList(h1);
//     }
// }