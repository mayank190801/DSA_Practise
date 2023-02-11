public class merge2sorted {
    public static void main(String[] args) {
        
    }

    //let's see sir code for this question, no doubt
     // MERGGE 2 LISTS
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(-1);
        ListNode c = d, c1 = l1, c2 = l2;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                c.next = c1;
                c1 = c1.next;
            } else {
                c.next = c2;
                c2 = c2.next;
            }
            c = c.next;
        }
        if (c1 == null) {
            c.next = c2;
        } else {
            c.next = c1;
        }
        return d.next;
    }

    //pretty obvious mayank singh approach
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    //     ListNode d = new ListNode(-1);
    //     ListNode c = d;  

    //     //what would be the better aproach for this piece of code?
    //     //think about it, that's what that qualcomm guy taught me
    //     while(l1 != null && l2 != null){
    //         if(l1.val <= l2.val){
    //             c.next = l1;
    //             l1 = l1.next;
    //             c = c.next;
    //             c.next = null;
    //         }else{
    //             c.next = l2;
    //             l2 = l2.next;
    //             c = c.next;
    //             c.next = null;
    //         }
    //     }

    //     while(l1 != null){
    //         c.next = l1;
    //         l1 = l1.next;
    //         c = c.next;
    //         c.next = null;
    //     }

    //     while(l2 != null){
    //         c.next = l2;
    //         l2 = l2.next;
    //         c = c.next;
    //         c.next = null;
    //     }

    //     return d.next;
    // }
    
}
