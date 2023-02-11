public class duplicate1{
    public static void main(String[] args) {
        
    }

    //removeDuplicates1 sir method
    //using one single pointer forever
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c = head;
        ListNode f = null;

        while(c != null){   
            f = c.next;
            while(f != null && f.val == c.val){
                f = f.next;
            }
            //now 
            c.next = f;
            c = c.next;
        }

        return head;
    }

    //MY CODE IS BELOW
    // public ListNode deleteDuplicates(ListNode head) {
    //     if(head == null || head.next == null){
    //         return head;
    //     }

    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     head= dummy;
    //     ListNode prev = head;
    //     ListNode curr = head.next;

    //     while(curr.next != null){
    //         if(curr.next.val == curr.val){
    //             ListNode temp = curr.next;
    //             prev.next = temp;
    //             curr.next = null;
    //             curr = temp;
    //         }else{
    //             prev = curr;
    //            curr = curr.next;             
    //         }
    //    }

    //     return head.next;
    // }
}