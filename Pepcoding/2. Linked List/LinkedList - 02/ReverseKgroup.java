public class ReverseKgroup{

    public static void main(String[] args) {
        
    }

    ListNode ah = null, at = null, th = null, tt = null;
    //using addFirst and length method for now
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k == 1){
            return head;
        }
        //clever code
        int len = size(head);
        ListNode curr = head;

        while(len >= k){
            //teen bando ko uthao aur add First mein daalte jao
            int t = k;
            while(t -- > 0){
                ListNode f = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = f;
            }
            //we have k nodes in th and tt tail, prett cool
            if(ah == null){
                ah = th;
                at = tt;
            }else{
                at.next = th;
                at = tt;
            }
            th=tt=null;
            len -= k;
        }

        return ah;

    }

    public int size(ListNode c){
        int size = 0;
        while(c != null){
            c = c.next;
            size++;
        }
        return size;
    }

    //th and tt concept is super cool for sure
    //put ahead and again and add again and add again
    public void AddFirst(ListNode curr){
        if(th == null){
            th = tt = curr;
        }else{
            curr.next = th;
            th = curr;
        }
    }





    //below is the proper way of how we should deal with linkedlist question
    //step by step break them into pieces and solve the pieces one by one
    //not a biggie
    //some reverse method for the timepass
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null, forw = null;
        while (curr != null) {
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    //first method using recursion
    public ListNode reverseKGroup(ListNode head, int k) {
        
        //pretty clear code
        if(head == null || head.next == null || k == 1){
            return head;
        }


        int dummyk = k;
        var curr = head;
        while(k -- >1){
            curr = curr.next;
            //simple as that bro
            if(curr == null){
                return head;
            }
        }

        
        ListNode fhead = curr.next;
        curr.next = null;

        //using recursion and reverse funtions respectively
        ListNode recns = reverseKGroup(fhead, dummyk);
        ListNode revAns = reverseList(head);

        head.next = recns;
        return revAns;
       
    }

}