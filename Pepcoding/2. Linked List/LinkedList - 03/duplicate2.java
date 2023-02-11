public class duplicate2 {
    public static void main(String[] args) {
        
    }

    //sir version of code using only two pointers
    //pretty cool for sure
    public ListNode deleteDuplicates(ListNode head) {
        

        //dummy made this question easier to solve for sure
        //so always beware of this helpful method in linkedlist
        //for sure
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head= dummy;

        ListNode p = head;
        ListNode c = head.next;

        //now check for edge cases baby, only edge cases left now
        while(c != null){
            
            while(c.next != null && c.val == c.next.val){
                c = c.next;
            }

            if(p.next != c){ //duplicates present
                p.next = c.next;
                c = c.next;
            }else{
                p = c;
                c = c.next;
            }
        }

        return head.next;
    }

    //my way of solving this problem, let's see sir solution
    // public ListNode deleteDuplicates(ListNode head) {

    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     head= dummy;

    //     ListNode p = head;
    //     ListNode c = head.next;
    //     ListNode f = null;

    //     while(c != null){   
    //         f = c.next;
    //         boolean check = false;
    //         while(f != null && f.val == c.val){
    //             check = true;
    //             f = f.next;
    //         }
    //         //now 
    //         if(check){
    //             p.next = f;
    //             c = f;
    //         }else{  
    //             p = c;
    //             c.next = f;
    //             c = c.next;
    //         }
    //     }

    //     return head.next;
    // }
}
