public class add22number {

    public int sizeNode(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }

        return size;
    }



    //no reverse and shit method should be used for now, i should try solving it asap, that should be my goal
    //that should be my goal for life, and i should focus on it
    public ListNode addTwooNumbers(ListNode l1, ListNode l2) {

        //base case for sure
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        //now let's figure out some shit and all
        ListNode dummy = new ListNode(0);
        //now solve it 
        ListNode pointer = dummy;
        ListNode c1 = l1, c2 = l2;

        int asize= sizeNode(l1);
        int bsize = sizeNode(l2);

        //now change the place of them according to the needs of the question
        //that you should be able to do for  sure
        int diff = Math.abs(asize - bsize);
        while(diff != 0){
            if(asize > bsize){
                ListNode node = new ListNode(c1.val);
                c1 = c1.next;
                node.next = pointer;
                pointer = node;
            }else{
                ListNode node = new ListNode(c2.val);
                c2 = c2.next;
                node.next = pointer;
                pointer = node;
            }
            diff--;
        }

        //now we will keep till the end
        while(c1 != null){
            int sum = c1.val + c2.val;
            int carry = sum > 9 ? 1 : 0;
            ListNode node = new ListNode(sum%10);
            node.next = pointer;
            pointer = node;

            ListNode temp = pointer.next;

            //in between i have to make sure that pointer is doing it work
            while(carry != 0){
                int currSum = temp.val + carry;
                carry = currSum > 9 ? 1 : 0;
                temp.val = currSum%10;
                temp = temp.next;
            }
        
        }

        //this is the tricky part, that is what do we have to return, i gotta think about it
        ListNode nhead = reverse(pointer);
        if(nhead == 0) nhead = nhead.next;

        return nhead;
    }





    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////




    //this was done using reverse method for this quesiton
    //but now i have to try solving it using other method
    public ListNode reverse(ListNode head){
        ListNode curr = head, prev = null, future = null;

        while(curr != null){
            future = curr.next;
            curr.next = prev;

            prev = curr;
            curr = future;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reverse(l1);
        l2 = reverse(l2);

        return addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //you can make modification in one of those
        ListNode d = new ListNode(-1);
        ListNode pointer = d;

        ListNode c1 = l1;
        ListNode c2 = l2;

        int carry = 0;
        while(c1 != null || c2 != null){  
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

        if(carry != 0){
            ListNode temp = new ListNode(carry);
            pointer.next = temp;
            pointer = temp;
        }


    }

    
}
