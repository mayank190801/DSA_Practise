public class add2number{

    // brilliant code for sure
    // let's think about this for once
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //you can make modification in one of those
        ListNode d = new ListNode(-1);
        ListNode pointer = d;

        ListNode c1 = l1;
        ListNode c2 = l2;

        int carry = 0;
        
        //i likeed this method a lot more for sure, 
        //but there could be another which i did previous
        //one and and two while loops 
        //this only one loop , and does all the work
        //really impressive
        while(c1 != null || c2 != null || carry != 0){  
            int sum1 = c1 != null ? c1.val : 0;
            int sum2 = c2 != null ? c2.val : 0;

            int sum = sum1 + sum2 + carry;
            int curr = sum%10;
            carry = sum >= 10 ? 1 : 0;
            
            ListNode temp = new ListNode(curr);
            pointer.next = temp;
            pointer = temp;

            if(c1 != null)
                c1 = c1.next;
            
            if(c2 != null)
                c2 = c2.next;
        }
        return d.next;
    }


}