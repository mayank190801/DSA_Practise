public class mergesort {
    public static void main(String[] args) {
       //don't type your code here 
    }

    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {

        if( head == null || head.next == null ){
            return head;
        }

        ListNode mid = mid(head);
        ListNode second = mid.next;
        mid.next = null;

        head = sortList(head);
        second = sortList(second);

        //now compare the nodes
        //now both are sorted, you have to simply use merge 2 sorted shit
        return  mergeTwoLists(head, second);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode d = new ListNode(-1);
        ListNode c = d;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                c.next = l1;
                l1 = l1.next;
                c = c.next;
                c.next = null;
            }else{
                c.next = l2;
                l2 = l2.next;
                c = c.next;
                c.next = null;
            }
        }

        if(l1 != null){
            c.next = l1;
        }

        if(l2 != null){
            c.next = l2;
        }

        return d.next;
    }
}
